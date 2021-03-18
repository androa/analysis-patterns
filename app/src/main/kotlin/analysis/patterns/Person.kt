package analysis.patterns

class Person(private val observasjoner: MutableList<Observasjon> = mutableListOf()) {
    fun observe(observasjon: Observasjon) = observasjoner.add(observasjon)
    fun has(observation: KategoriObservasjon) = observasjoner.any { it == observation }
}
