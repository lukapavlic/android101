package si.um.feri.firebaseauthdb.dao

import si.um.feri.firebaseauthdb.vao.Meritev

interface MeritveDao {
    fun dodaj(m : Meritev)
    fun vrniVse() :List<Meritev>
    fun vrniVseAsync(meritveNaVoljo :(List<Meritev>)->Unit)
}