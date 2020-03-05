package si.um.feri.primerizimskasola2020.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import si.um.feri.primerizimskasola2020.R

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = BlankFragment()
        fragmentTransaction.add(R.id.fragmentHolder, fragment)
        fragmentTransaction.commit()
    }

}
