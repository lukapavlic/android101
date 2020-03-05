package si.um.feri.primerizimskasola2020.communicationFragmentActivity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import si.um.feri.primerizimskasola2020.R
import si.um.feri.primerizimskasola2020.fragments.BlankFragment

class CommunicationActivity : AppCompatActivity(),
    CommunicationFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = CommunicationFragment()
        fragmentTransaction.add(R.id.communicationHolder, fragment)
        fragmentTransaction.commit()
    }

    override fun onFragmentInteraction(text: String) {
        Toast.makeText(this, "Prikazano iz aktivnosti -> " + text, Toast.LENGTH_SHORT).show()
    }
}
