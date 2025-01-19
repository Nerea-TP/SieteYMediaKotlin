
import sieteymedia.SieteYMedia
import recursos.Carta


var sietemedia:SieteYMedia= SieteYMedia()
fun main() {
    presentarJuego()
    turnoJugador()
    turnoBanca()
}

fun presentarJuego() {
        println("- El usuario es el jugador y el ordenador la banca.")
        println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.")
        println("- las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.")
        println("- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.")
        println("- El jugador va pidiendo cartas a la banca de una en una.")
        println("- El jugador puede plantarse en cualquier momento.")
        print("- Si la suma de los valores de las cartas sacadas es superior ")
        println("a 7 y medio, el jugador 'se pasa de siete y medio' y pierde.")
        println("- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta está obligada a sacar cartas hasta empatar o superar al jugador.")
        println("- Si la banca consigue empatar o superar la puntuación del jugador 'sin pasarse de siete y medio', gana la banca.")
        println("- La banca no se puede plantar y tiene que empatar o superar la puntuación del jugador sin pasarse.")
        println("- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.")
        println("\nEmpecemos!!!\n")
    }

    fun turnoJugador() {
        var opc = 'C'
        // obligamos a que como mínimo se tenga 1 carta
        println("Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte")
        while (!sietemedia.esFinTurno() && opc == 'C') {
            sietemedia.darCartasJugador()
            println("Éstas son tus cartas:")
            val cartasJugador = sietemedia.cartasJugador
            mostrarCartas(cartasJugador)
            val valor = sietemedia.valorCartasJugador
            println("\n\tValor de tus cartas: $valor")
            if (valor < 7.5) {
                // suponemos que el usuario teclea bien !!!
                println("\n¿Pides [C]arta o te [P]lantas?")
                opc = readln().trim().uppercase()[0]
            }
        }
    }

    fun turnoBanca() {
        // lo primero es consultar el valor que alcanzó el jugador en su turno
        val valor = sietemedia.valorCartasJugador
        if (sietemedia.esFinTurno()) {
            println("Jugador, te has pasado en tu jugada anterior, GANA LA BANCA")
            println("Adios")
            return
        }
        println("\n\nTurno de banca ...")

        // juega hasta empatar o superar
        while (sietemedia.valorCartasBanca < valor) {
            sietemedia.darCartasBanca()
        }
        println("Éstas son las cartas de la banca:")
        val cartasBanca = sietemedia.cartasBanca
        mostrarCartas(cartasBanca)
        val valor1 = sietemedia.valorCartasBanca
        println("\nValor de las cartas de la banca: $valor1")
        if (valor1 > 7.5) {
            println("ME PASÉ, GANAS TÚ")
        } else {
            println("GANA LA BANCA")
        }
    }

    fun mostrarCartas(cartas:MutableList<Carta>) {
        print("\t" + cartas)
    }
