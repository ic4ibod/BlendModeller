import org.junit.jupiter.api.AfterEach

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CubeTest {

    val nutrients: Map<String, Double> = mapOf(
        "c" to 123.0,
        "n" to 40.0,
        "p" to 19.0,
        "k" to 31.0,
        "s" to 4.0
        )

    val testCube = Cube()

    @Test
    fun `add ingredients to a cube` () {
    // Bit of a pointless test; just checing it works
        for ((name, amount) in nutrients) {
            testCube.addIngredient(Ingredient(name, amount))

        }
    }

    @Test
    fun `get ingredients back from a cube`() {
        for ((name, amount) in nutrients) {
            testCube.addIngredient(Ingredient(name, amount))
        }

        val testIngs = capitalise(nutrients.keys)
        val cubeKeys = testCube.getIngredients()
        assertEquals(testIngs, cubeKeys)
    }

    @Test
    fun `get total kgs of ingredients in cube` () {

        var expected: Double = 0.0
        for ((name, amount) in nutrients) {
            testCube.addIngredient(Ingredient(name, amount))
            expected += amount
        }
        val totalKgs = testCube.totalKgsIngredients()
        assertEquals(expected, totalKgs)
    }

    @Test
    fun `get remaining weight in cube` () {
        var expected: Double = 0.0
        for ((name, amount) in nutrients) {
            testCube.addIngredient(Ingredient(name, amount))
            expected += amount
        }
        expected = 1000 - expected

        val remaining = testCube.totalRemaining()
        assertEquals(expected, remaining)
    }

    private fun capitalise( input: Set<String>): Set<String> {
        val toReturn: MutableSet<String> = mutableSetOf()
        for ( character in input) {
            toReturn.add(character.uppercase())
        }
        return toReturn
    }
}