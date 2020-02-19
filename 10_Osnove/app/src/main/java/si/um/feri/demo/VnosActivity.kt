package si.um.feri.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_vnos.*
import si.um.feri.demo.vao.Oseba

class VnosActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "${BuildConfig.APPLICATION_ID}.log.VnosActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vnos)

        Log.i(LOG_TAG,"onCreate()")

        button.setOnClickListener {
            Log.i(LOG_TAG,"button.OnClick()")

            val visina :Double = editVisina.text.toString().toDouble()
            val teza = editTeza.text.toString().toDouble()
            val o = Oseba(ime.text.toString(), teza, visina)

            Toast.makeText(this,"Vaš ITM: ${o.izracunajItm()}",Toast.LENGTH_SHORT).show()

            val i = Intent(this, PregledActivity::class.java)
            i.putExtra("oseba",o)
            startActivity(i)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i(LOG_TAG,"onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_TAG,"onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_TAG,"onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOG_TAG,"onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(LOG_TAG,"onRestart()")
    }

}
