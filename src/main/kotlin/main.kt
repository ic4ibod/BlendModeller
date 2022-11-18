fun main () {

// Lets make 100 Ingredient objects

    val ingredients: MutableList<Ingredient> = mutableListOf()
    for (i in 1..100) { ingredients.add(Ingredient("$i")) }
    println(ingredients.size)

}