package com.example.rest_volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMeasurements()
    }

    private fun getMeasurements() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://164.8.250.18:8080/measurements/rest/measurements"
        val headers: MutableMap<String, String> = mutableMapOf<String, String>()
        headers.put("API-Key", "16ec1e09-aa26-446c-b6fa-f73fa89fee53")
        headers.put("user", "dummy@user.si")
        headers.put("Content-type", "application/json")
        val gson = Gson()

        // Request a string response from the provided URL.
        val stringReq = CustomRequest(
                url,
                arrayListOf<Measurement>()::class.java,
                headers,
                Response.Listener { response ->
                    val measurements = JSONArray(response)
                    var str_measurements = ""
                    for (i: Int in 0 until measurements.length()) {
                        val measurement = gson.fromJson(measurements.getJSONObject(i).toString(), Measurement::class.java)
                        str_measurements = str_measurements + "\n" +
                                measurement.label + " " + measurement.value + " " +
                                measurement.unit
                    }
                    textView_measurements.text = str_measurements
                },
                Response.ErrorListener { error ->
                    error.printStackTrace()
                    textView_measurements.text = "That didn't work!"
                })
        queue.add(stringReq)
    }
}
