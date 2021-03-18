package analysis.patterns

class Range(lower: Number, upper: Number) {
    private val lower = lower.toDouble()
    private val upper = upper.toDouble()
    fun includes(quantity: Quantity): Boolean = quantity.size in lower..upper
}