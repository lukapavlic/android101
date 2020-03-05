package si.um.feri.socasnost.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import si.um.feri.socasnost.BuildConfig
import si.um.feri.socasnost.MainActivityHolder

class StevecDoStoBound : Service() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.StevecDoStoBound"
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(LOG_TAG, "StevecDoStoBound onCreate().")
    }

    override fun onDestroy() {
        Log.i(LOG_TAG, "StevecDoStoBound onDestroy().")
        super.onDestroy()
    }

    var i = 0;

    fun dajNaslednjo() :Int = i++

    override fun onBind(intent: Intent): IBinder? {
        Log.i(LOG_TAG, "StevecDoStoBound onBind()")
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.i(LOG_TAG, "StevecDoStoBound onUnbind()")
        return super.onUnbind(intent)
    }

    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService(): StevecDoStoBound = this@StevecDoStoBound
    }

}