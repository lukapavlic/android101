package si.um.feri.zs.meritve.vao

import java.io.Serializable

data class Profil (
    var ime :String? ,
    var priimek :String?,
    var email :String?,
    var telesnaVisina :Double?
) : Serializable