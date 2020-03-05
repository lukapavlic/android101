package si.um.feri.primerizimskasola2020.recyclerView

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

    private val forecasts = MutableLiveData<List<Forecast>>()

    fun refresh() {
        fetchForecasts()

    }

    private fun fetchForecasts() {
        forecasts.value = arrayListOf(
            Forecast(1.0, "Pon"),
            Forecast(-5.0, "Tor"),
            Forecast(-3.0, "Sre"),
            Forecast(2.0, "Čet"),
            Forecast(-2.0, "Pet"),
            Forecast(-1.0, "Sob"),
            Forecast(8.0, "Ned")
        )
    }

    override fun onCleared() {
        super.onCleared()
    }
}
