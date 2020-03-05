package com.example.rest_okhttp

import android.util.Log
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray

class OKHttpRestClient {

    private val endpoint = "http://164.8.250.18:8080/measurements/rest"
    private val key = "16ec1e09-aa26-446c-b6fa-f73fa89fee53"

    /*
    {
        "comment": "Popoldanska meritev",
        "geo": "15.43, 43.432",
        "id": ,
        "label": "Telesna višina",
        "measurementType": "BODY_HEIGHT",
        "timeStamp": 1549877500611,
        "unit": "cm",
        "userEmail": "dummy@user.si",
        "value": 178
    }
     */
    fun postMeasurement(m :Measurement) {
        val json = "{" +
                "\"comment\":\"${m.comment}\"," +
                "\"geo\":\"${m.geo}\"," +
                "\"label\":\"${m.label}\"," +
                "\"measurementType\":\"${m.type}\"," +
                "\"timeStamp\":\"${m.timeStamp}\"," +
                "\"unit\":\"${m.units}\"," +
                "\"userEmail\":\"${m.userEmail}\"," +
                "\"value\":\"${m.value}\"" +
                "}"
        Log.i(BuildConfig.APPLICATION_ID,"OKHttpRestClient.postMeasurement: $json")

        val mediaType = "application/json; charset=utf-8".toMediaType()
        val body = json.toRequestBody(mediaType)
        // val body = RequestBody.create(json, mediaType) -> Deprecated

        val client = OkHttpClient()
        val request = Request.Builder().
            url("$endpoint/measurements").
            header("Content-type", "application/json").
            header("API-Key", key).
            header("user", "dummy@user.si").
            post(body).
            build()

        val response = client.newCall(request).execute()
        Log.i(BuildConfig.APPLICATION_ID,"Response Code : " + response.code)
        Log.i(BuildConfig.APPLICATION_ID,"Response: " + response.body?.string())
    }

    fun getMeasurements(userId: String) : ArrayList<Measurement> {
        Log.i(BuildConfig.APPLICATION_ID,"OKHttpRestClient.getMeasurements")
        Log.i(BuildConfig.APPLICATION_ID,"GET $endpoint/measurements")
        val client = OkHttpClient()
        val request = Request.Builder().
            url("$endpoint/measurements").
            header("Content-type", "application/json").
            header("API-Key", key).
            header("user", userId).
            build()

        val response = client.newCall(request).execute()
        val responseBody=response.body?.string()
        Log.i(BuildConfig.APPLICATION_ID,"Response Code : " + response.code)
        Log.i(BuildConfig.APPLICATION_ID, "Response: $responseBody")

        val ja=JSONArray(responseBody)
        val res= arrayListOf<Measurement>()
        for (i in 0 until ja.length()) {
            val jo=ja.getJSONObject(i)
            val m = Measurement(
                jo.getString("comment"),
                jo.getString("geo"),
                jo.getInt("id"),
                jo.getString("label"),
                jo.getString("measurementType"),
                jo.getLong("timeStamp"),
                jo.getString("unit"),
                jo.getString("userEmail"),
                jo.getDouble("value"))
            res.add(m)
        }
        return res
    }
}