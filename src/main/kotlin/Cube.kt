class Cube {

    val theCube: MutableList<Ingredient> = mutableListOf()

    fun addIngredient (ingredient: Ingredient): Boolean {
        theCube.add(ingredient)
        return true
    }

    fun getIngredients(): Set<String> {
        val ingredients: MutableSet<String> = mutableSetOf()
        for (ingredient in theCube) {
            ingredients.add(ingredient.name)
        }
        return ingredients
    }

    fun totalKgsIngredients(): Double {
        var totalKgs = 0.0
        theCube.forEach { totalKgs += it.kilos }
        return totalKgs
    }

    fun totalRemaining(): Double {
        var remaining = 1000.0
        theCube.forEach { remaining -= it.kilos }
        return remaining
    }


}