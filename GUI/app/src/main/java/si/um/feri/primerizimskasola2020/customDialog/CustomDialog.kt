package si.um.feri.primerizimskasola2020.customDialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_custom_dialog.*
import si.um.feri.primerizimskasola2020.R
import si.um.feri.primerizimskasola2020.dialog.PrimerDialogFragment

class CustomDialog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_dialog)
        odpriDialog.setOnClickListener {
            CustomDialogFragment().show(
                supportFragmentManager,
                "customDialog"
            )
        }

    }
}
