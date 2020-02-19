package si.um.feri.firebaseauthdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import si.um.feri.firebaseauthdb.dao.MeritveDao
import si.um.feri.firebaseauthdb.dao.MeritveFirestoreDao
import si.um.feri.firebaseauthdb.dao.MeritveLocalDBDao
import si.um.feri.firebaseauthdb.dao.MeritveMemoryDao
import si.um.feri.firebaseauthdb.fragments.DodajanjeMeritveFragment
import si.um.feri.firebaseauthdb.fragments.ProfilFragment
import si.um.feri.firebaseauthdb.fragments.SeznamMeritevFragment

class MainActivity : AppCompatActivity() {

    var daoToUse :MeritveDao? = MeritveMemoryDao

    private val view_dm = DodajanjeMeritveFragment(this)
    private val view_sm = SeznamMeritevFragment(this)
    private val view_p = ProfilFragment()

    private fun getFragments() :Array<Fragment> {
        view_dm.mainActivity=this
        return arrayOf(view_dm,view_sm,view_p)
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

        //switch here
        //daoToUse = MeritveLocalDBDao(this)
        daoToUse = MeritveFirestoreDao()

        switchFragment(0)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}