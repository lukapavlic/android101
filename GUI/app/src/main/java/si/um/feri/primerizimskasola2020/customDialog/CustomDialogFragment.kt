package si.um.feri.primerizimskasola2020.customDialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.add_new.view.*
import si.um.feri.primerizimskasola2020.R

class CustomDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val mDialogView = LayoutInflater.from(it).inflate(R.layout.add_new, null)
            val builder = AlertDialog.Builder(it)
                .setView(mDialogView)
                .setTitle("Dodaj meritev")
            val mAlertDialog = builder.show()
            mDialogView.saveBtn.setOnClickListener {
                mAlertDialog.dismiss()
                Toast.makeText(
                    context,
                    "Ime: ${mDialogView.dialogNameEt.text} \nPriimek: ${mDialogView.dialogLastnameEt.text} \nTeža: ${mDialogView.dialogWeightEt.text} \nVišina: ${mDialogView.dialogHeightEt.text}",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
            mDialogView.cancleBtn.setOnClickListener {
                mAlertDialog.dismiss()
            }
            mAlertDialog
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}