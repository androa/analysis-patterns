package analysis.patterns

// Blood group A, B, OK/low
class Fenomen(name: String, type: FenomenType, private val range: Range? = null) : ObservasjonsKonsept(name) {
    init {
        type.add(this)
    }

    fun includes(temperature: MåltObservasjon): Boolean {
        if (range == null) return false
        return range.includes(temperature.value)
    }
}

// Height, strength, fever, oil level, Blood group
class FenomenType(name: String) {
    val fenomener = mutableListOf<Fenomen>()

    fun add(fenomen: Fenomen) = fenomener.add(fenomen)
}

// Disease -> Diabetes -> Diabetes2
open class ObservasjonsKonsept(private val name: String, vararg supertypes: ObservasjonsKonsept) {
    private val supertypes = supertypes.toList()
    override fun equals(other: Any?): Boolean {
        return other is ObservasjonsKonsept && name == other.name || supertypes.any { it == other }
    }
}
