package si.um.feri.zcdemo

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_drugi.*

class DrugiActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.DrugiActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(LOG_TAG,"onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drugi)

        txtId.text=this.toString()

        btnMain.setOnClickListener {
            toast("btnMain")
            startActivity(Intent(this,MainActivity::class.java))
        }

        btnMainInFinish.setOnClickListener {
            toast("btnMainInFinish")
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        btnFinish.setOnClickListener {
            toast("btnFinish")
            finish()
        }

        btnFinishWithResult.setOnClickListener {
            toast("btnFinishWithResult")
            val i=Intent()
            i.data= Uri.parse("Tu maš.")
            setResult(Activity.RESULT_OK,i)
            finish()
        }

        btnMainClearTop.setOnClickListener {
            toast("btnMainClearTop")
            val i=Intent(this,MainActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }

        btnDrugaApp.setOnClickListener {
            toast("btnDrugaApp")
            val i=Intent().setClassName("si.um.feri.demo","si.um.feri.demo.VnosActivity")
            //val i=Intent().setClassName("si.um.feri.demo","si.um.feri.demo.SeznamActivity")
            //val i=Intent().setClassName("si.um.feri.demo","si.um.feri.demo.FancySeznamActivity")
            startActivity(i)
        }

    }

    override fun onStart() {
        Log.i(LOG_TAG,"onStart()")
        super.onStart()
    }

    override fun onResume() {
        Log.i(LOG_TAG,"onResume()")
        super.onResume()
    }

    override fun onPause() {
        Log.i(LOG_TAG,"onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.i(LOG_TAG,"onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(LOG_TAG,"onDestroy()")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.i(LOG_TAG,"onRestart()")
        super.onRestart()
    }

}

fun AppCompatActivity.toast(s :String) = Toast.makeText(this,s,Toast.LENGTH_SHORT).show()

