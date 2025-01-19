package sieteymedia

import recursos.Baraja
import recursos.Carta

class SieteYMedia {
    private val baraja: Baraja = Baraja()
    val cartasJugador: MutableList<Carta> = mutableListOf()
    val cartasBanca: MutableList<Carta> = mutableListOf()
    private var finTurno = false
    init {
        baraja.barajar()
        /* se van pidiendo cartas al jugar pero matemáticamente a partir de 15 siempre
        * nos pasamos
        * hay 12 cartas de medio puntos, si sacara estas 12 luego cartas con valor 1
        * vemos que a partir de 15 cartas siempre se pasas
        */
    }

    fun esFinTurno(): Boolean {
        this.finTurno = valorCartas(cartasJugador) > 7.5
        return finTurno
    }

    var valorCartasJugador: Double=0.0
        get() = valorCartas(cartasJugador)
    var valorCartasBanca: Double=0.0
        get() = valorCartas(cartasBanca)

    fun plantar(){
        finTurno = true
    }

    fun darCartasJugador() {
        val c = baraja.darCartas(1)[0]
        cartasJugador.add(c)
        valorCartasJugador=valorCartas(cartasJugador)
    }

    fun darCartasBanca() {
        val c = baraja.darCartas(1)[0]
        cartasBanca.add(c)
        valorCartasBanca=valorCartas(cartasBanca)
    }

    private fun valorCartas(cartas: MutableList<Carta>): Double {
        var total = 0.0
        var vali: Int

        for (i in cartas) {
            vali = i.numero
            if (vali > 7) {
                total += 0.5
            } else {
                total += vali
            }
        }
        return total
    }
}