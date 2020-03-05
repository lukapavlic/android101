package si.um.feri.primerizimskasola2020.viewPager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_tab_view_pager.*
import si.um.feri.primerizimskasola2020.R


class TabViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_view_pager)

        view_pager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabs, view_pager) { tab, position ->
            tab.text = when (position) {
                0 -> "Today"
                else -> "Forecast"
            }
        }.attach()
    }
}
