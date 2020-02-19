package si.um.feri.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_seznam.view.*
import si.um.feri.demo.vao.Oseba

class FancySeznamAdapter(ctx: Context, vls: Array<Oseba>) : ArrayAdapter<Oseba>(ctx, -1, vls) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = inflater.inflate(R.layout.item_seznam, parent, false)

        rowView.itemIme.text = getItem(position)?.ime
        rowView.itemTeza.text = "${getItem(position)?.teza} kg"
        rowView.itemVisina.text = "${getItem(position)?.visina} m"

        return rowView
    }

}