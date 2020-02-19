package si.um.feri.socasnost.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import si.um.feri.socasnost.BuildConfig
import java.util.*
import kotlin.concurrent.timerTask

class Stevec : Service() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.Stevec"
    }

    var timer: Timer? = null
    var count = 0

    override fun onCreate() {
        super.onCreate()
        Log.i(LOG_TAG, "Stevec onCreate().")

        timer = Timer()
        timer?.schedule(timerTask {
            count++
            broadcast(count)
            Log.i(LOG_TAG, "$count")
        }, 1000, 1000)
    }

    private fun broadcast(i: Int) {
        val intent = Intent("SporociloZaBroadcast")
        intent.putExtra("i", i)
        getApplication().sendBroadcast(intent)
    }

    override fun onDestroy() {
        Log.i(LOG_TAG, "Stevec onDestroy().")
        timer?.cancel()
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.i(LOG_TAG, "Stevec onStartCommand().")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.i(LOG_TAG, "Stevec onBind().")
        return null
    }

}
