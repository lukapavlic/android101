package si.um.feri.roomtodo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {

    @Query("SELECT * from todo_table ORDER BY todo ASC") //TODO pridobi vse po ASC redu
    fun getAlphabetizedTodos(): LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE) //TODO vnesi todo-ja
    suspend fun insert(todo: Todo)

    @Query("DELETE FROM todo_table") //TODO izbrisi vse vnose v tabeli
    suspend fun deleteAll()
}