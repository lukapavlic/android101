package si.um.feri.demo.vao

import android.util.Log
import si.um.feri.demo.BuildConfig
import java.io.Serializable

data class Oseba(
    var ime :String,
    var teza :Double,
    var visina :Double) :Serializable {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.vao.log.Oseba"
    }

    override fun toString(): String {
        return "$ime: $teza kg; $visina m"
    }

    fun izracunajItm() :Double {
        try {
            return teza / (visina * visina)
        } catch (e :Exception) {
            Log.e(LOG_TAG,e.message)
        }
        return 0.0
    }

}

//data class Oseba(
//    var ime :String,
//    var teza :Double,
//    var visina :Double) :Serializable

//class Oseba : Serializable {
//    var ime :String=""
//    var teza = 95.0
//    var visina = 1.86
//}
