package si.um.feri.firebaseauthdb

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FCMService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) { // ...
        Log.d(BuildConfig.APPLICATION_ID, "Pošiljatelj: ${remoteMessage.from}")
        if (remoteMessage.data.size > 0) {
            Log.d(BuildConfig.APPLICATION_ID, "Podatki: ${remoteMessage.data}")
        }
        if (remoteMessage.notification != null) {
            Log.d(BuildConfig.APPLICATION_ID, "Obvestilo ${remoteMessage.notification!!.body}")
        }
    }

}
