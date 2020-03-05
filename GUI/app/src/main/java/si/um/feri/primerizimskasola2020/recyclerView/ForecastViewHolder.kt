package si.um.feri.primerizimskasola2020.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val degrees = view.degrees
    private val day = view.day
    fun bind(forecast: Forecast) {
        degrees.text = forecast.degrees.toString()
        day.text = forecast.day
    }
}