import java.io.Serializable
import java.util.*

data class Osb(
    var ime: String?,
    var priimek: String?,
    var email: String?,
    var datumRojsta: Calendar?,
    var telesnaTeza: Double
)

open class Persona(ime :String) {
    constructor() : this("Neznano") {
        println("Privzeti od Persone")
    }
}

class Sofer(ime :String, izkusenj :Int) : Persona(ime) {
    constructor() : this("Neznano",5) {
        println("Privzeti od Soferja")
    }
}

class InitOrderDemo(var name: String) {
    val firstProperty = "First property: $name"
    init {
        println("First initializer block that prints ${name}")
    }
    val secondProperty = "Second property: ${name.length}"
    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Racun() : Serializable {
    var a: Int
        public get() {
            println("berem")
            return a
        }
        private set(value) {
            a=value
        }

    var b: Int=1
    var avtor: String=""
}

fun String.superca() :String {
    return "--- $this ---"
}

class Demo {

    fun demo1() {
        val name = "Marko" // napaka ob času prevajanja, če spreminjamo!
        var age = 20
        val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
        val readOnlyNumbers: List<Int> = numbers
        numbers.clear()
        //readOnlyNumbers.clear() // se ne prevede!
    }

    fun demoOseba() {
        val o = Osb("Janez", 	"Kranjski","janez@gmail.com", 	Calendar.getInstance(),92.5)
        val o2=o.copy(ime="Marko")
        val o3=o.copy(ime="Marko")

        println(o.toString())
        println(o2.toString())
        println(o3.toString())

        if (o == o3) {
            println("Enako")
        } else {
            println("ni enako")
        }
    }

    fun demo3() {
        val p = Persona("Mirko")
        val s = Sofer("Marko",5)
    }

    fun get4() :Int {
        println("Vracam 4 |")
        return 4;
    }

    fun demoLazy() {
        val r by lazy {  get4() }
        println("Delam nekaj |")
        println("r je $r |")
    }

    fun demoCallback(koga : (String) -> (Unit)) {
        println("Delam nekaj |")
        println("Kličem Metko |")
        koga("Metka")
        println("Delam nekaj |")
        println("Kličem Jankota |")
        koga("Janko")
        println("Delam nekaj |")
        println("Kličem Zvonkota |")
        koga("Zvonko")
    }

    fun demoElvis() {
        var ime: String = "Marko"
        //ime = null //napaka v času prevajanja
        ime.length

        var ime2: String? = "Marko"
        ime2 = null
        //ime2.length //napaka v času prevajanja

        ime2?.length
        val len2= if (ime2 != null) ime2.length else -1
        //krajše - "Elvis" operator
        val len3 = ime2?.length ?: -1
    }

    fun demoExtension() {
        val s : String = "STRING"
        println(s.superca())
    }

}
