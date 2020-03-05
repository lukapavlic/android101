package si.um.feri.demo

import android.app.ListActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import si.um.feri.demo.vao.Oseba
import si.um.feri.demo.vao.SeznamVsehOseb

class SeznamActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, SeznamVsehOseb.seznam)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        val i = listAdapter.getItem(position) as Oseba
        Toast.makeText(this, "${i.ime} ima ${i.teza} kg (ITM = ${i.izracunajItm()}).", Toast.LENGTH_LONG).show()
    }

}