package si.um.feri.primerizimskasola2020.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

import si.um.feri.primerizimskasola2020.R

class PrimerDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_primer_dialog, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.question)
                .setPositiveButton(
                    R.string.ok
                ) { _, _ ->
                    Toast.makeText(context, "Dobro, nadaljujemo...", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(
                    R.string.cancel
                ) { _, _ ->
                    Toast.makeText(context, "OK, gremo domov!", Toast.LENGTH_SHORT).show()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}