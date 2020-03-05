package com.example.rest_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() , ServiceCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_measurements.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val measurements = CoroutineScope(Dispatchers.IO).async {
                    getAllMeasurements()
                    //asynchronous call to REST endpoint
                    //getAllMeasurementsAsynch()
                }.await()

                //after the asynchronous call, we can use the result and show it in the Main thread
                var measurementsStr = ""
                for (m in measurements) {
                    measurementsStr = "$measurementsStr\n${m.label} ${m.value} ${m.unit}"
                }

                textView_measurements.text = measurementsStr
            }
        }

        button_postMeasurement.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                CoroutineScope(Dispatchers.IO).async {
                    //asynchronous call to REST endpoint
                    postMeasurement()
                }.await()
            }
        }
    }

    override fun onSuccess(measurements: ArrayList<Measurement>) {
        //after the asynchronous call, we can use the result and show it in the Main thread
        Log.i("Main info", "updating Main UI")
        var measurementsStr = ""
        for (m in measurements) {
            measurementsStr = "$measurementsStr\n${m.label} ${m.value} ${m.unit}"
        }

        textView_measurements.text = measurementsStr
    }

    override fun onError(throwable: Throwable) {
        TODO("not implemented")
    }

    private fun getAllMeasurements(): ArrayList<Measurement> {
        val client = RetrofitRestClient()

        return client.getAllMeasurements()
    }

    private fun postMeasurement() {
        val measurement = Measurement(null,null, null,"Visina",
                "BODY_HEIGHT", Date().time, "cm", "dummy@user.si", 178.0)

        val client = RetrofitRestClient()
        client.addMeasurement(measurement)
    }

    /*private fun getAllMeasurementsAsynch() {
        val client = RetrofitRestClient()

        client.getMeasurementsAsynch(this)
    }*/
}
