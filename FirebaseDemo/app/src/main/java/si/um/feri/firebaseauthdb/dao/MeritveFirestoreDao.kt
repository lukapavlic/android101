package si.um.feri.firebaseauthdb.dao

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import si.um.feri.firebaseauthdb.BuildConfig
import si.um.feri.firebaseauthdb.vao.Meritev
import java.lang.Exception

class MeritveFirestoreDao:MeritveDao {

    val db = FirebaseFirestore.getInstance()

    var vseMeritveCache = mutableListOf<Meritev>()

    constructor() {
        //val dbs = FirebaseFirestoreSettings.Builder()
        //    .setTimestampsInSnapshotsEnabled(true)
        //    .build()
        //db.setFirestoreSettings(dbs)
        vrniVseAsync {}
    }

    override fun dodaj(m: Meritev) {
        db.collection("/meritve").document("${m.id}").set(hashMapOf(
            "tip" to m.tip,
            "vrednost" to m.vrednost,
            "enote" to m.enote
        ))
            .addOnSuccessListener {
                Log.d(BuildConfig.APPLICATION_ID,"Dodano: $m")
            }
            .addOnFailureListener { e ->
                Log.e(BuildConfig.APPLICATION_ID, "Napaka.", e)
            }
        vseMeritveCache.add(m)
    }

    override fun vrniVseAsync(meritveNaVoljo: (List<Meritev>) -> Unit) {
        db.collection("/meritve").get()
            .addOnSuccessListener {result ->
                Log.d(BuildConfig.APPLICATION_ID,"Podatki so prebrani: $result")
                var ret = mutableListOf<Meritev>()
                for (doc in result) {
                    var docId=0L;
                    try {
                        docId=doc.id.toLong()
                    } catch (e :Exception) {

                    }
                    ret.add(Meritev(docId,
                        doc.getString("tip")?:"?",
                        doc.getDouble("vrednost")?:0.0,
                        doc.getString("enote")?:"e"
                    ))
                }
                meritveNaVoljo(ret)
                vseMeritveCache=ret
            }
            .addOnFailureListener { e ->
                Log.e(BuildConfig.APPLICATION_ID, "Napaka.", e)
            }
    }

    override fun vrniVse(): List<Meritev> {
        vrniVseAsync {}
        return vseMeritveCache
    }

}