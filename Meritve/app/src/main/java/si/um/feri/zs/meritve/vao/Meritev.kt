package si.um.feri.zs.meritve.vao

import java.io.Serializable

data class Meritev (
    var tip :String,
    var vrednost :Double,
    var enote :String?
) :Serializable