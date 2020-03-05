package si.um.feri.zs.meritve.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dodajanje_meritve.*
import si.um.feri.zs.meritve.MainActivity
import si.um.feri.zs.meritve.R
import si.um.feri.zs.meritve.vao.Meritev
import si.um.feri.zs.meritve.vao.VseMeritve

class DodajanjeMeritveFragment : Fragment() {

    var mainActivity :MainActivity? =null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dodajanje_meritve, container, false)
    }

    override fun onResume() {
        super.onResume()

        gumbVnosMeritve.setOnClickListener {
            val m = Meritev(
                inputTipMeritve.selectedItem.toString(),
                inputVrednost.text.toString().toDouble(),
                inputEnote.text.toString()
            )
            VseMeritve.meritve.add(m)
            mainActivity?.switchFragment(1)
        }
    }

}
