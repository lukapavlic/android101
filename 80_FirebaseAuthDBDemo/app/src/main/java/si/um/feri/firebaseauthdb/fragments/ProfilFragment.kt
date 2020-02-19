package si.um.feri.firebaseauthdb.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_profil.*
import si.um.feri.firebaseauthdb.BuildConfig
import si.um.feri.firebaseauthdb.R
import si.um.feri.firebaseauthdb.vao.Profil

class ProfilFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onResume() {
        super.onResume()

        val p=loadProfil()

        inputIme.setText(p.ime)
        inputPriimek.setText(p.priimek)
        inputEmail.setText(p.email)
        inputVisina.setText(p.telesnaVisina.toString())

        gumbVnosProfila .setOnClickListener {
            saveProfil(Profil(
                inputIme.text.toString(),
                inputPriimek.text.toString(),
                inputEmail.text.toString(),
                inputVisina.text.toString().toDouble()
            ))
            Log.d(BuildConfig.APPLICATION_ID, loadProfil().toString())
            Toast.makeText(context,"Profil hranjen",Toast.LENGTH_SHORT).show()
        }
    }

    fun loadProfil() :Profil {
        val sp=context?.getSharedPreferences(BuildConfig.APPLICATION_ID,Context.MODE_PRIVATE)
        val ret = Profil(
            sp?.getString("profil_inputIme",""),
            sp?.getString("profil_inputPriimek",""),
            sp?.getString("profil_inputEmail",""),
            sp?.getString("profil_inputVisina","0")?.toDouble()
        )
        return ret
    }

    fun saveProfil(p :Profil) {
        val sp=context?.getSharedPreferences(BuildConfig.APPLICATION_ID,Context.MODE_PRIVATE)?.edit()
        sp?.putString("profil_inputIme",p.ime)
        sp?.putString("profil_inputPriimek",p.priimek)
        sp?.putString("profil_inputEmail",p.email)
        sp?.putString("profil_inputVisina",p.telesnaVisina.toString())
        sp?.commit()
    }

}
