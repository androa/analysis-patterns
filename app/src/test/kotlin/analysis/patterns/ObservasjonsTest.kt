package analysis.patterns

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ObservasjonerTest {
    // Knowledge level
    private val blood = FenomenType("Blood group")
    private val bloodA = Fenomen("A", blood)
    private val bloodB = Fenomen("B", blood)
    private val disease = ObservasjonsKonsept("disease")
    private val diabetes = ObservasjonsKonsept("diabetes", disease)
    private val diabetes2 = ObservasjonsKonsept("diabetes2", diabetes)
    private val temp = FenomenType("Kroppstemperatur")
    private val fever = Fenomen("Litt feber", temp, Range(37, 38))
    private val fever2 = Fenomen("Mye feber", temp, Range(38, 40))
    private val fever3 = Fenomen("DØØØØØD", temp, Range(40, 99))

    @Test
    fun `observasjoner`() {
        // Operational level
        val person = Person()
        person.observe(Presence(bloodA))
        person.observe(Presence(diabetes))
        person.observe(MåltObservasjon(temp, Quantity(37.5)))

        assertTrue(person.has(Presence(fever)))
        assertTrue(person.has(Presence(disease)))
        assertTrue(person.has(Presence(diabetes)))
        assertFalse(person.has(Presence(diabetes2)))
    }
}
