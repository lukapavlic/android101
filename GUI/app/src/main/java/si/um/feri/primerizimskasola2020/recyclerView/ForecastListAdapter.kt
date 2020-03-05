package si.um.feri.primerizimskasola2020.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import si.um.feri.primerizimskasola2020.R

class ForecastListAdapter(var forecast: ArrayList<Forecast>) :
    RecyclerView.Adapter<ForecastViewHolder>() {
    fun updateForeasts(newForecast: List<Forecast>) {
        forecast.clear()
        forecast.addAll(newForecast)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ForecastViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
    )

    override fun getItemCount() = forecast.size
    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(forecast[position])
    }
}