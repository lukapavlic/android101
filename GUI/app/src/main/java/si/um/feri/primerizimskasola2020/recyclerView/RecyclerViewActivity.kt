package si.um.feri.primerizimskasola2020.recyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*
import si.um.feri.primerizimskasola2020.R

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private lateinit var forecastAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        viewManager = LinearLayoutManager(this)
        forecastAdapter = ForecastListAdapter(
            arrayListOf(
                Forecast(1.0, "Pon"),
                Forecast(-5.0, "Tor"),
                Forecast(-3.0, "Sre"),
                Forecast(2.0, "Čet"),
                Forecast(-2.0, "Pet"),
                Forecast(-1.0, "Sob"),
                Forecast(8.0, "Ned")
            )
        )

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModel.refresh()
        forecastList.apply {
            layoutManager = viewManager
            adapter = forecastAdapter
        }
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()

            Toast.makeText(this, "Refreshed", Toast.LENGTH_SHORT).show()

        }
    }
}
