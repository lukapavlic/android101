package si.um.feri.firebaseauthdb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_seznam_meritev.*
import si.um.feri.firebaseauthdb.MainActivity
import si.um.feri.firebaseauthdb.R

class SeznamMeritevFragment(val main :MainActivity) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_seznam_meritev, container, false)
    }

    override fun onResume() {
        super.onResume()
        seznamVsehMeritev.adapter = ArrayAdapter(context!!,android.R.layout.simple_list_item_1, main.daoToUse?.vrniVse()?: listOf())
    }

}

