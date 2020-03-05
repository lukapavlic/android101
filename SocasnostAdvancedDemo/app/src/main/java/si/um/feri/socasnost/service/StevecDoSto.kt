package si.um.feri.socasnost.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import si.um.feri.socasnost.BuildConfig
import si.um.feri.socasnost.MainActivityHolder

class StevecDoSto : Service() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.StevecDoSto"
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(LOG_TAG, "StevecDo100 onCreate().")
    }

    override fun onDestroy() {
        Log.i(LOG_TAG, "StevecDo100 onDestroy().")
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        MainActivityHolder.act?.setBesedilo("StevecDo100")

        Log.i(LOG_TAG, "StevecDo100 onStartCommand().")

        //Thread(Runnable{
            for (i in 1..100) {
                if (i % 10 == 0) Log.d(LOG_TAG, "Po 10: $i")
                try {
                    Thread.sleep(50)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            this@StevecDoSto.stopSelf()
       // }).start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.i(LOG_TAG, "StevecDo100 onBind()")
        return null
    }

}