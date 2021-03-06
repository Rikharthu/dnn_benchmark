package ru.gordinmitya.common

class BenchmarkResult(
    val loops: Int,
    // time in milliseconds
    val preparation: Long,
    val firstRun: Long,
    val min: Long,
    val max: Long,
    val avg: Double
) {
    override fun toString(): String {
        return "avg=${"%.2f".format(avg)}ms min=${min}ms max=${max}ms"
    }

    companion object {
        fun fromMeasurements(
            preparation: Long,
            times: List<Long>
        ): BenchmarkResult {
            return BenchmarkResult(
                times.size,
                preparation,
                times[0],
                times.min()!!,
                times.max()!!,
                times.average()
            )
        }
    }
}