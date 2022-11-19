/**
 * The class for the Cube - a 1000kg cube built with Ingredients
 *
 * @property[theCube] A mutable list of Ingrgedient objects
 */
class Cube {

    //TODO: Add a way of stopping the ingredients exceeding 1000 kilos

    val theCube: MutableList<Ingredient> = mutableListOf()
    var used: Double = 0.0
    var remaining: Double = 0.0

    /**
     * Adds ingredients to theCube
     *
     * @param[ingredient] an Ingredient object
     */
    fun addIngredient (ingredient: Ingredient) {
        theCube.add(ingredient)
        used = totalKgsIngredients()
        remaining = 1000.0 - used
    }

    /**
     * Returns a list of the ingredients in the current cube
     */
    fun getIngredients(): Set<String> {
        val ingredients: MutableSet<String> = mutableSetOf()
        for (ingredient in theCube) {
            ingredients.add(ingredient.name)
        }
        return ingredients
    }

    /**
     * Returns the total kilograms in the cube so far
     */
    private fun totalKgsIngredients(): Double {
        var totalKgs = 0.0
        theCube.forEach { totalKgs += it.kilos }
        return totalKgs
    }
}