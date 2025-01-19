package recursos
import kotlin.random.Random

class Baraja{
    private var cartas: MutableList<Carta> = mutableListOf()
    private var primeraMazo:Int=0

    init{
       //se añade a la baraja la carta con el palo y numero
        for (p in Palo.values()) {
            for (j in 0..11) {
                if (j == 7 || j == 8) {
                    continue
                }
               cartas.add(Carta(p,j+1))
            }
        }
    }

    fun barajar() {
        //baraja el mazo, es decir, la cartas sin dar
        for (i in primeraMazo until cartas.size) {
            val posicionAzar = Random.nextInt((cartas.size - primeraMazo) + primeraMazo)
            val temp = cartas[i]
            cartas.add(i,cartas[posicionAzar])
            cartas[posicionAzar] = temp
        }
    }

    fun darCartas(numCartasDar: Int): MutableList<Carta> {
        //coge cartas del mazo para dar
        val cartasParaDar: MutableList<Carta> = mutableListOf()
        val cartasEnMazo = cartas.size - primeraMazo
        if (cartasEnMazo > numCartasDar) {
            var x = 0
            for (i in 0..numCartasDar) {
                cartasParaDar.add(i,cartas[i + primeraMazo])
                x++
            }
            primeraMazo += x
        }
        return cartasParaDar
    }
}



