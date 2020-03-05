package si.um.feri.firebaseauthdb.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_dodajanje_meritve.*
import si.um.feri.firebaseauthdb.LoginActivity
import si.um.feri.firebaseauthdb.MainActivity
import si.um.feri.firebaseauthdb.R
import si.um.feri.firebaseauthdb.vao.Meritev

class DodajanjeMeritveFragment(val main : MainActivity) : Fragment() {

    var mainActivity : MainActivity? =null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dodajanje_meritve, container, false)
    }

    override fun onResume() {
        super.onResume()

        gumbVnosMeritve.setOnClickListener {
            val m = Meritev(
                System.currentTimeMillis(),
                inputTipMeritve.selectedItem.toString(),
                inputVrednost.text.toString().toDouble(),
                inputEnote.text.toString()
            )
            main.daoToUse?.dodaj(m)
            mainActivity?.switchFragment(1)
        }

        gumbOdjava.setOnClickListener {
            val builder= AlertDialog.Builder(context)
            builder.setTitle("Odjava")
            builder.setMessage("Se res želite odjaviti?")
            builder.setPositiveButton("Da") { dialog, which ->
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(context,LoginActivity::class.java))
                mainActivity?.finish()
            }
            builder.setNegativeButton("Ne") { dialog, which ->
                dialog.dismiss()
            }
            builder.create().show()
        }
    }

}
