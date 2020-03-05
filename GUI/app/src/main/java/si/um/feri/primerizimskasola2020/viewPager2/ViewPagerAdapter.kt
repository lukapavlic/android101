package si.um.feri.primerizimskasola2020.viewPager2

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                WeatherTodayFragment.newInstance()
            }
            else -> {
                WeatherForecastFragment.newInstance()
            }
        }
    }

}


