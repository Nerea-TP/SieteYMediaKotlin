
package recursos

class Carta(private var palo: Palo, val numero: Int) {

    override fun toString(): String {
        return "$palo, $numero"
    }
}