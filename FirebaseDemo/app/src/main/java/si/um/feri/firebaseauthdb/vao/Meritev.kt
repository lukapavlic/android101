package si.um.feri.firebaseauthdb.vao

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Meritev (
    @PrimaryKey(autoGenerate = true) val id :Long,
    var tip :String,
    var vrednost :Double,
    var enote :String
) :Serializable {

    override fun toString(): String {
        return "$tip = $vrednost $enote"
    }

}
