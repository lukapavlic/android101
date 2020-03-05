package si.um.feri.socasnost

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import si.um.feri.socasnost.asynctask.BackgroundTask
import si.um.feri.socasnost.coroutine.CoroutineDemo
import si.um.feri.socasnost.intentservice.Delavec
import si.um.feri.socasnost.service.Stevec
import si.um.feri.socasnost.service.StevecDoSto
import si.um.feri.socasnost.service.StevecDoStoBound
import java.lang.Runnable

object MainActivityHolder {
    var act :MainActivity?=null;
}

class MainActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.MainActivity"
    }

    fun setBesedilo(b :String) {
        textViewStevec.text=b
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainActivityHolder.act=this

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

        buttonStevecDo100Bound.setOnClickListener {
            if (mBound) {
                setBesedilo("Povezana storitev: ${mService.dajNaslednjo()}")
            }
        }

        buttonStevecStart.setOnClickListener {
            startService(Intent(this, Stevec::class.java))
        }

        buttonStevecStop.setOnClickListener {
            stopService(Intent(this, Stevec::class.java))
        }

        buttonCoroutine.setOnClickListener {
            GlobalScope.launch {
                CoroutineDemo().racunanjeDaTeKap()
            }
        }

        buttonCoroutineVzporedno.setOnClickListener {
            GlobalScope.launch {
                CoroutineDemo().vzporednoRacunanjeDaTeKap()
            }
        }

        buttonCoroutineNapredno.setOnClickListener {
            GlobalScope.launch {
                val j= async { withTimeout(7000) {
                     CoroutineDemo().naprednoRacunanjeDaTeKap()
                 }}
                delay(2000)
                Log.i(LOG_TAG, "A smo že?")

                delay(5000)
                if (!j.isCompleted) {
                    j.cancel()
                    Log.i(LOG_TAG, "Smola, bo treba malce hitreje.")
                } else {
                    Log.i(LOG_TAG, "OK, naj vam bo.")
                }
            }
        }

    }

    private lateinit var mService: StevecDoStoBound
    private var mBound: Boolean = false

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as StevecDoStoBound.LocalBinder
            mService = binder.getService()
            mBound = true
        }
        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this, StevecDoStoBound::class.java).also {
            bindService(it, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        if (mBound) {
            unbindService(connection)
            mBound = false
        }
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
