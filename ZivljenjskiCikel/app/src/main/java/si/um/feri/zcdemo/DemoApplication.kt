package si.um.feri.zcdemo

import android.app.Application
import android.content.res.Configuration
import android.util.Log

class DemoApplication : Application() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.DemoApplication"
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(LOG_TAG,"onCreate()")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.i(LOG_TAG,"onTerminate()")
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        Log.i(LOG_TAG,"onConfigurationChanged()")

        if (newConfig?.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i(LOG_TAG,"onConfigurationChanged --> ORIENTATION_LANDSCAPE")
        } else if (newConfig?.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.i(LOG_TAG,"onConfigurationChanged --> ORIENTATION_PORTRAIT")
        }
    }

}
