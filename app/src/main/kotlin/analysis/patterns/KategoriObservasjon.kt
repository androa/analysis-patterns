package analysis.patterns

abstract class KategoriObservasjon(private val phenomenon: ObservasjonsKonsept) : Observasjon() {
    override fun equals(other: Any?): Boolean {
        return other is KategoriObservasjon && phenomenon == other.phenomenon
    }
}

class Absence(phenomenon: ObservasjonsKonsept) : KategoriObservasjon(phenomenon) {
    override fun equals(other: Any?): Boolean {
        return other is Absence && super.equals(other)
    }
}

class Presence(phenomenon: ObservasjonsKonsept) : KategoriObservasjon(phenomenon) {
    override fun equals(other: Any?): Boolean {
        return other is Presence && super.equals(other)
    }
}
