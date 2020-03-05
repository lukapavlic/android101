package si.um.feri.socasnost.coroutine

import android.util.Log
import kotlinx.coroutines.*
import si.um.feri.socasnost.BuildConfig
import si.um.feri.socasnost.MainActivityHolder

class CoroutineDemo {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.CoroutineDemo"
    }

    suspend fun racunanjeDaTeKap() {
        Log.i(LOG_TAG, "racunanjeDaTeKap - a=2, b=3.")
        val vsota = sestej(2,3)
        val produkt = zmnozi(2, 3)
        Log.i(LOG_TAG, "racunanjeDaTeKap - konec. Rezultata: $vsota, $produkt")
    }

    suspend fun vzporednoRacunanjeDaTeKap() {
        Log.i(LOG_TAG, "vzporednoRacunanjeDaTeKap - začetek.")
        withContext(Dispatchers.Main){
            Log.i(LOG_TAG, "a=2, b=3")
            val vsota = async{sestej(2,3,true)}
            val produkt = async{zmnozi(2,3,true)}
            Log.i(LOG_TAG, "Končno smo dobili rezultata: ${vsota.await()}, ${produkt.await()}")
        }
        Log.i(LOG_TAG, "vzporednoRacunanjeDaTeKap - konec.")
    }

    suspend fun naprednoRacunanjeDaTeKap() {
        Log.i(LOG_TAG, "naprednoRacunanjeDaTeKap - začetek.")
        withContext(Dispatchers.Main){
            Log.i(LOG_TAG, "a=2, b=3")

            val vsota = async{sestej(2,3,true)}
            val produkt = async{zmnozi(2,3,true)}

            Log.i(LOG_TAG, "Takle mamo: ${vsota.await()}, ${produkt.await()}")

        }
        Log.i(LOG_TAG, "naprednoRacunanjeDaTeKap - konec.")
    }

    suspend fun sestej(a :Int, b :Int, ui :Boolean=false): Int {
        Log.i(LOG_TAG, "Seštevam $a in $b 0%")
        delay(700)
        Log.i(LOG_TAG, "Seštevam $a in $b 25%")
        delay(700)
        Log.i(LOG_TAG, "Seštevam $a in $b 50%")
        delay(700)
        Log.i(LOG_TAG, "Seštevam $a in $b 75%")
        delay(700)
        Log.i(LOG_TAG, "Seštevam $a in $b = ${a+b}")

        if (ui) MainActivityHolder.act?.setBesedilo("$a + $b = ${a+b}")

        return a+b
    }

    suspend fun zmnozi(a :Int, b :Int, ui :Boolean=false): Int {
        Log.i(LOG_TAG, "Množim $a in $b 0%")
        delay(1000)
        Log.i(LOG_TAG, "Množim $a in $b 25%")
        delay(1000)
        Log.i(LOG_TAG, "Množim $a in $b 50%")
        delay(1000)
        Log.i(LOG_TAG, "Množim $a in $b 75%")
        delay(1000)
        Log.i(LOG_TAG, "Množim $a in $b = ${a*b}")

        if (ui) MainActivityHolder.act?.setBesedilo("$a * $b = ${a*b}")

        return a*b
    }

}