package si.um.feri.firebaseauthdb.dao

import si.um.feri.firebaseauthdb.vao.Meritev

object MeritveMemoryDao :MeritveDao {

    override fun dodaj(m: Meritev) {
        vseMeritve.add(m)
    }

    override fun vrniVse(): List<Meritev> {
        return vseMeritve
    }

    override fun vrniVseAsync(meritveNaVoljo: (List<Meritev>) -> Unit) {
        meritveNaVoljo(vseMeritve)
    }

    var vseMeritve = mutableListOf<Meritev>()

}