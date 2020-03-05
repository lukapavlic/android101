package si.um.feri.firebaseauthdb.dao

import android.content.Context
import android.util.Log
import androidx.room.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import si.um.feri.firebaseauthdb.BuildConfig
import si.um.feri.firebaseauthdb.vao.Meritev

class MeritveLocalDBDao(val appContext :Context) : MeritveDao {

    val db = Room.databaseBuilder(appContext,AppDatabase::class.java, "meritve.db").build()

    override fun dodaj(m: Meritev) {
        GlobalScope.launch {
            db.meritevDao().insertAll(m)
            Log.d(BuildConfig.APPLICATION_ID,"Dodano: $m")
        }
    }

    override fun vrniVseAsync(meritveNaVoljo: (List<Meritev>) -> Unit) {
        Thread{
            meritveNaVoljo(db.meritevDao().getAll())
        }.start()
    }

    override fun vrniVse(): List<Meritev> {
        var ret :List<Meritev> = mutableListOf<Meritev>()
        val t=Thread{
            ret = db.meritevDao().getAll()
        }
        t.start()
        t.join()
        return ret
    }

}

@Dao
interface MeritveRoomDao {
    @Query("SELECT * FROM Meritev")
    fun getAll(): List<Meritev>
    @Insert
    fun insertAll(vararg m: Meritev)
}

@Database(entities = arrayOf(Meritev::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun meritevDao(): MeritveRoomDao
}
