package si.um.feri.primerizimskasola2020.linearLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.primer_simple_linear_layout.*
import si.um.feri.primerizimskasola2020.R

class PrimerSimpleLinearLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.primer_simple_linear_layout)
        pozdravno_sporocilo.text = "To smo določili v kodi"
    }
}
