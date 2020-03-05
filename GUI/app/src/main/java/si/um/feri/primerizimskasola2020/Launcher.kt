package si.um.feri.primerizimskasola2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_launcher.*
import si.um.feri.primerizimskasola2020.communicationFragmentActivity.CommunicationActivity
import si.um.feri.primerizimskasola2020.constraintLayout.ConstraintLayoutActivity
import si.um.feri.primerizimskasola2020.customDialog.CustomDialog
import si.um.feri.primerizimskasola2020.dialog.DialogActivity
import si.um.feri.primerizimskasola2020.gestures.GesturesActivity
import si.um.feri.primerizimskasola2020.horizontalVerticalLayout.Layouts
import si.um.feri.primerizimskasola2020.linearLayout.PrimerSimpleLinearLayout
import si.um.feri.primerizimskasola2020.menu.MenuActivity
import si.um.feri.primerizimskasola2020.motionLayout.MotionLayout
import si.um.feri.primerizimskasola2020.notification.NotificationActivity
import si.um.feri.primerizimskasola2020.recyclerView.RecyclerViewActivity
import si.um.feri.primerizimskasola2020.viewPager2.TabViewPagerActivity

class Launcher : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        communicationActivity.setOnClickListener {
            startActivity(Intent(this, CommunicationActivity::class.java))
        }
        constraintActivity.setOnClickListener {
            startActivity(Intent(this, ConstraintLayoutActivity::class.java))
        }
        customDialog.setOnClickListener {
            startActivity(Intent(this, CustomDialog::class.java))
        }
        simpleDialog.setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }
        gestures.setOnClickListener {
            startActivity(Intent(this, GesturesActivity::class.java))
        }
        horizontalVertical.setOnClickListener {
            startActivity(Intent(this, Layouts::class.java))
        }
        linearLayout.setOnClickListener {
            startActivity(Intent(this, PrimerSimpleLinearLayout::class.java))
        }
        menuActivity.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
        motionActivity.setOnClickListener {
            startActivity(Intent(this, MotionLayout::class.java))
        }
        notificationActivity.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }
        recyclerViewActivity.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
        viewPagerActivity.setOnClickListener {
            startActivity(Intent(this, TabViewPagerActivity::class.java))
        }
    }
}
