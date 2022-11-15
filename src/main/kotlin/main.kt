fun main () {

    val nutrients: Map<String, Double> = mapOf(
        "c" to 123.0,
        "n" to 40.0,
        "p" to 19.0,
        "k" to 31.0,
        "s" to 4.0
    )

    val input = nutrients.keys

    input.forEach { println("${it.uppercase()}") }

}