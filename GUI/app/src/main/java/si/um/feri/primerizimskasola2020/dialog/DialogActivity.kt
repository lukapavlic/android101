package si.um.feri.primerizimskasola2020.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import si.um.feri.primerizimskasola2020.R

class DialogActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        PrimerDialogFragment().show(supportFragmentManager, "dialog")

    }
}
