class Pile {

    val pile: MutableSet<Cube> = mutableSetOf()
    val pileSize: Int
        get() = pile.size

    fun addCube(cube: Cube) {
        pile.add(cube)
    }

    fun emptyPile() = pile.clear()

    fun nutrAve(nutrient: String): Double {
        var totalKilos = 0.0
        for (cube in pile) {
            for ( ingredient in cube.theCube) {
                if (ingredient.key.equals(nutrient)) totalKilos += ingredient.value
            }
        }
        return totalKilos/this.pileSize
    }

    fun dump(): Map<String, Double> {

        val  nutrientNames: MutableSet<String> = mutableSetOf()
        for (cube in pile) {
            for (ingredient in cube.theCube) nutrientNames.add(ingredient.key)
        }

        val report: MutableMap<String, Double> = mutableMapOf()
        for (nutrient in nutrientNames) {
            report.put(nutrient, nutrAve(nutrient))
        }

        return report
    }
}