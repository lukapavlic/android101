package com.example.rest_okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_measurements.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val measurements = CoroutineScope(Dispatchers.IO).async {
                    //asynchronous call to REST endpoint
                    getAllMeasurements()
                }.await()

                //after the asynchronous call, we can use the result and show it in the Main thread
                var measurementsStr = ""
                for (measurement in measurements) {
                    measurementsStr = "$measurementsStr\n${measurement.label} ${measurement.value} ${measurement.timeStamp}"
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

    private fun getAllMeasurements(): ArrayList<Measurement> {
        val client = OKHttpRestClient()

        return client.getMeasurements("dummy@user.si")
    }

    private fun postMeasurement() {
        val meritev = Measurement(
            "Popoldanska meritev",
            "15.43, 43.432",
            null,
            "Telesna visina",
            "BODY_HEIGHT", Date().time,
            "cm",
            "dummy@user.si",
            178.0)

        val client = OKHttpRestClient()
        client.postMeasurement(meritev)
    }
}
