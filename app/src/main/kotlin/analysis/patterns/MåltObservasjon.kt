package analysis.patterns

class MåltObservasjon(fenomenType: FenomenType, public val value: Quantity) : Observasjon() {
    private lateinit var phenomenon: KategoriObservasjon

    init {
        fenomenType.fenomener.first { phenomenon ->
            phenomenon.includes(this)
        }.also {
            classifyAs(Presence(it))
        }
    }

    private fun classifyAs(phenomenon: KategoriObservasjon) = phenomenon.also { this.phenomenon = it }

    override fun equals(other: Any?): Boolean = when (other) {
        is KategoriObservasjon -> other == phenomenon
        is MåltObservasjon -> other.value == value
        else -> false
    }
}
