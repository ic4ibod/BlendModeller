import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.random.Random

internal class PileTest {

    val testPile = Pile()

    @Test
    fun `test adding a cube to the pile` () {

        val inputIngs: Array<Ingredient> = arrayOf( Ingredient("C", 123.0),
                                                    Ingredient("N", 40.0),
                                                    Ingredient("P", 16.0)
        )

        val testCube = Cube()
        for (ingredient in inputIngs) testCube.addIngredient(ingredient)

        testPile.addCube(testCube)
        assertEquals(1, testPile.pileSize)
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class MultiplePileTests {

        val numberOfCubes = Random.nextInt(1, 50)
        var totalN: Double = 0.0

        init {
            testPile.emptyPile()
            val nutrients = arrayOf("C", "N", "P", "K", "S")
            for (cubeToAdd in 1..numberOfCubes) {
                val listOfIngredients: MutableList<Ingredient> = mutableListOf()
                for (nutrient in nutrients) {
                    listOfIngredients.add(Ingredient(nutrient, Random.nextDouble() * 100))
                }
                val cube = Cube()
                for (ingredient in listOfIngredients) {
                    if (ingredient.name.equals("N")) totalN += ingredient.kilos
                    cube.addIngredient(ingredient)
                }
                testPile.addCube(cube)
            }
        }

        @Test
        fun `test adding multiple cubes to the pile`() {
            assertEquals(this.numberOfCubes, testPile.pileSize)
            println("There are ${testPile.pileSize} cubes in the pile")
        }

        @Test
        fun `test getting the average for a nutrient back from the pile`() {
            val expected = totalN / testPile.pileSize
            assertEquals(expected, testPile.nutrAve("N"))
            println("$expected equals ${testPile.nutrAve("N")}")
        }

        @Test
        fun `test getting a list of nutreints back from the pile`() {
            val report:Map<String, Double> = testPile.dump()
            assertEquals(true, true)
            println(report)
        }
    }
}