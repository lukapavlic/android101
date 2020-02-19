package si.um.feri.firebaseauthdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonRegister.setOnClickListener {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(ime.text.toString(),geslo.text.toString())
                .addOnSuccessListener {
                    Toast.makeText(this,"Registracija uspešna",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }
                .addOnFailureListener{
                    Toast.makeText(this,"Neuspešna registracija. ${it.message}",Toast.LENGTH_SHORT).show()
                }
        }

        buttonLogin.setOnClickListener {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(ime.text.toString(),geslo.text.toString())
                .addOnSuccessListener {
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"Neuspešna prijava. ${it.message}",Toast.LENGTH_SHORT).show()
                }
        }

    }

    override fun onStart() {
        super.onStart()
        if (FirebaseAuth.getInstance().currentUser!=null) {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

}
