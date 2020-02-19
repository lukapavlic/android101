package si.um.feri.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_pregled.*
import si.um.feri.demo.vao.Oseba
import si.um.feri.demo.vao.SeznamVsehOseb

class PregledActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.PregledActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregled)

        val o = intent.getSerializableExtra("oseba") as Oseba

        txtIme.text="Ime: ${o.ime}"
        txtVisina.text="Višina: ${o.visina}"
        txtTeza.text="Teža: ${o.teza}"
        txtITM.text="itm= %.2f".format(o.izracunajItm())

        gumbek.setOnClickListener {
            Log.i(LOG_TAG,"gumbek.OnClick()")
            val o: Oseba =intent.getSerializableExtra("oseba") as Oseba
            SeznamVsehOseb.seznam.add(o)
            startActivity(Intent(this, SeznamActivity::class.java))
            finish()
        }

        gumbekFancy.setOnClickListener {
            Log.i(LOG_TAG,"gumbekFancy.OnClick()")
            val o: Oseba =intent.getSerializableExtra("oseba") as Oseba
            SeznamVsehOseb.seznam.add(o)
            startActivity(Intent(this, FancySeznamActivity::class.java))
            finish()
        }

    }
}
