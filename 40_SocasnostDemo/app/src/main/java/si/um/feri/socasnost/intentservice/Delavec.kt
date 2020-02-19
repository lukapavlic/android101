package si.um.feri.socasnost.intentservice

import android.content.Intent
import android.app.IntentService
import android.util.Log
import si.um.feri.socasnost.BuildConfig

class Delavec : IntentService("Delavec") {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.Delavec"
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.i(LOG_TAG, "Delavec onHandleIntent()")
        Log.i(LOG_TAG, "Delavec delam.")
        try {

            Thread.sleep(2000)
            Log.i(LOG_TAG, "Delavec ZELO delam.")
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        Log.i(LOG_TAG, "Delavec končal.")
    }

}