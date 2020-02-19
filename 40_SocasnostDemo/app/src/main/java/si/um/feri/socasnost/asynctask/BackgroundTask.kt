package si.um.feri.socasnost.asynctask

import android.os.AsyncTask
import android.util.Log
import si.um.feri.socasnost.BuildConfig

class BackgroundTask : AsyncTask<String, Int, String>() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.BackgroundTask"
    }

    var progress : (Int) -> Unit = {}

   override fun doInBackground(vararg params: String): String {
        Log.i(LOG_TAG, "doInBackground() start")
        val ret = StringBuilder()
        var progress = 0
        for (s in params) {
            publishProgress(progress++)
            try {
                Thread.sleep(500)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            ret.append(s)
        }
        Log.i(LOG_TAG, "doInBackground() end")
        return ret.toString()
    }

    override fun onPostExecute(result: String) {
        Log.i(LOG_TAG, "onPostExecute() - $result")
        super.onPostExecute(result)
    }

    override fun onPreExecute() {
        Log.i(LOG_TAG, "onPreExecute()")
        super.onPreExecute()
    }

    override fun onProgressUpdate(vararg values: Int?) {
        Log.i(LOG_TAG, "onProgressUpdate() - ${values.asList()}")
        progress(values.get(0)?:0)
        super.onProgressUpdate(*values)
    }

}