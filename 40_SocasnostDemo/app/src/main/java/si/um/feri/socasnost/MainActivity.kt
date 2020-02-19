package si.um.feri.socasnost

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import si.um.feri.socasnost.asynctask.BackgroundTask
import si.um.feri.socasnost.intentservice.Delavec
import si.um.feri.socasnost.service.Stevec
import si.um.feri.socasnost.service.StevecDoSto
import java.lang.Runnable

class MainActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNiti.setOnClickListener {
            Thread(Runnable {
                Log.i(LOG_TAG, "buttonNiti.")
                Thread.sleep(3000)
                Log.i(LOG_TAG, "buttonNiti drugič.")
            }).start()
            Log.i(LOG_TAG, "buttonNiti tretjič.")
        }

        buttonBackgroundTask.setOnClickListener {
            val bt= BackgroundTask()
            bt.execute("Danes ","je ","res ","lep ","dan.")
            bt.progress={
                progressBar.progress=it+1
            }
        }

        buttonDelavec.setOnClickListener {
            startService(Intent(this, Delavec::class.java))
        }

        buttonStevecDo100.setOnClickListener {
            startService(Intent(this, StevecDoSto::class.java))
        }

        buttonStevecStart.setOnClickListener {
            startService(Intent(this, Stevec::class.java))
        }

        buttonStevecStop.setOnClickListener {
            stopService(Intent(this, Stevec::class.java))
        }

        buttonCoroutine.setOnClickListener {
            Log.i(LOG_TAG, "Start CR.")

            GlobalScope.launch {
                delay(3000)
                Log.i(LOG_TAG, "Evo nas.")
                toastSuspend("TO DELA")
                Log.i(LOG_TAG, "Gremo računat!")
                val c = sestej(2,3)
                val d = zmnozi(2,3)
                Log.i(LOG_TAG, "Rezultata: $c, $d")

                Log.i(LOG_TAG, "Gremo računat drugič!")
                val e = async{ sestej(5,6) }
                val f = async{ zmnozi(5,6) }
                Log.i(LOG_TAG, "Rezultata drugič: ${e.await()}, ${f.await()}")
            }
            Thread.sleep(1000) // wait for 2 seconds
            Log.i(LOG_TAG, "Stop CR.")
        }

    }

    suspend fun toastSuspend(message: CharSequence) = withContext(Dispatchers.Main) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    suspend fun sestej(a :Int, b :Int): Int {
        delay(1000)
        return a+b
    }

    suspend fun zmnozi(a :Int, b :Int): Int {
        delay(1000)
        return a*b
    }

    fun toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    val rec = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context?, intent: Intent?) {
            textViewStevec.text=intent?.getExtras()?.getInt("i").toString();
        }
    }

    override fun onResume() {
        registerReceiver(rec, IntentFilter("SporociloZaBroadcast"))
        super.onResume()
    };

    override fun onPause() {
        unregisterReceiver(rec)
        super.onPause()
    }

}
