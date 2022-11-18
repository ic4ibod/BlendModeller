fun main () {

// Lets make 100 Ingredient objects

    val ingredients: MutableList<Ingredient> = mutableListOf()
    for (i in 1..100) { ingredients.add(Ingredient("$i", 10, 20)) }
    val cube = Cube()
    for (ingredient in ingredients) { cube.addIngredient(ingredient) }
    println(cube.totalKgsIngredients())
    println(cube.totalRemaining())
}