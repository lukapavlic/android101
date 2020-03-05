package si.um.feri.zs.meritve

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import si.um.feri.zs.meritve.fragments.DodajanjeMeritveFragment
import si.um.feri.zs.meritve.fragments.ProfilFragment
import si.um.feri.zs.meritve.fragments.SeznamMeritevFragment

class MainActivity : AppCompatActivity() {

    var dm = DodajanjeMeritveFragment()
    val sm = SeznamMeritevFragment()
    val p = ProfilFragment()

    fun getFragments() :Array<Fragment> {
        dm.mainActivity=this
        return arrayOf(dm,sm,p)
    }

    fun switchFragment(pos: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_fragmentholder, getFragments()[pos])
            .commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_add -> {
                switchFragment(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_list -> {
                switchFragment(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                switchFragment(2)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchFragment(0)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}