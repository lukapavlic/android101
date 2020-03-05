package si.um.feri.firebaseauthdb.dao

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import si.um.feri.firebaseauthdb.BuildConfig
import si.um.feri.firebaseauthdb.vao.Meritev
import java.io.Serializable

class MeritveRestDao :MeritveDao {

    companion object {
        const val URL = "http://164.8.250.18:8080/measurements/"
    }

    private fun getService() :RetrofitService {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RetrofitService::class.java)
    }

    override fun dodaj(m: Meritev) {
        Log.d(BuildConfig.APPLICATION_ID,"MeritveRestDao.dodaj")
        val res = getService().postMeasurement(m.toMeritev()).execute()
    }

    override fun vrniVse(): List<Meritev> {
        Log.d(BuildConfig.APPLICATION_ID,"MeritveRestDao.vrniVse")
        var rezultat= arrayListOf<Meritev>()
        getService().getMeasurements().execute().body()?.forEach {
            rezultat.add(it.toMeritev())
        }
        return rezultat;
    }

    override fun vrniVseAsync(meritveNaVoljo: (List<Meritev>) -> Unit) {
        getService().getMeasurements().enqueue(object : Callback<List<Measurement>> {
            override fun onResponse(call: Call<List<Measurement>>, response: Response<List<Measurement>>) {
                if (response.code() == 200) {

                    var rezultat= arrayListOf<Meritev>()
                    response.body()?.forEach {
                        rezultat.add(it.toMeritev())
                    }
                    meritveNaVoljo(rezultat);
                }
            }
            override fun onFailure(call: Call<List<Measurement>>, t: Throwable) {
            }
        })
    }

}

interface RetrofitService {

    companion object {
        const val USER_ID = "dummy2@user.si"
        const val API_KEY = "API-Key: 16ec1e09-aa26-446c-b6fa-f73fa89fee53"
    }

    @Headers( "user: $USER_ID", API_KEY)
    @GET("rest/measurements")
    fun getMeasurements(): Call<List<Measurement>>

    @Headers("user: $USER_ID", API_KEY)
    @POST("rest/measurements")
    fun postMeasurement(@Body measurement: Measurement): Call<Measurement>

    @Headers("user: $USER_ID", API_KEY)
    @DELETE("rest/measurements/{id}")
    fun deleteMeasurement(@Path("id") id: String): Call<Void>
}

data class Measurement (
    var comment: String?,
    var geo: String?,
    var id: Long?,
    var label: String,
    var measurementType :String,
    var timeStamp: Long,
    var unit :String?,
    var userEmail: String,
    var value :Double
): Serializable

fun Measurement.toMeritev() :Meritev  = Meritev(id?:0,measurementType,value,unit?:"?")

fun Meritev.toMeritev() :Measurement  = Measurement("","",id,"",tip,0,enote,"",vrednost)
