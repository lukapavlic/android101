package si.um.feri.zcdemo

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(LOG_TAG,"onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtId.text=this.toString()

        btnDrugi.setOnClickListener {
            toast("btnDrugi")
            startActivity(Intent(this,DrugiActivity::class.java))
        }

        btnDrugiInFinish.setOnClickListener {
            toast("btnDrugiInFinish")
            startActivity(Intent(this,DrugiActivity::class.java))
            finish()
        }

        btnDrugiWithResult.setOnClickListener {
            toast("btnDrugiWithResult")
            startActivityForResult(Intent(this,DrugiActivity::class.java), 1)
        }

        btnFinish.setOnClickListener {
            toast("btnFinish")
            finish()
        }

        btnTel.setOnClickListener {
            toast("btnTel")
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:051051051")))

        }

        btnMap.setOnClickListener {
            toast("btnMap")
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=FERI,+Maribor")))
        }

        btnChrome.setOnClickListener {
            toast("btnChrome")
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://feri.um.si/")))
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, i: Intent?) {
        Log.i(LOG_TAG,"onActivityResult()")
        if (requestCode === requestCode) {
            if (resultCode === Activity.RESULT_OK) {
                toast("Rezultat: ${i?.data.toString()}")
            }
        }
    }

}
