import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.BeforeTest

internal class IngredientTest {

    val ingredient = Ingredient("n", 40.0)
    val ingredient2 = Ingredient("n", 20, 50)

    @Test
    fun `test that we can make an ingredient object` (){
        assertTrue( ingredient is Ingredient)
    }

    @Test
    fun `test we can read values from an ingredient object` () {
        val expected = 40.0
        assertEquals(expected, ingredient.kilos)
    }

    @Test
    fun `test we get a value back as a percentage` () {
        val expected = 40.0
        assertEquals(expected/1000, ingredient.percent)
    }

    @Test
    fun `test we get an uppercase name back` () {
        val expected: String = "n".uppercase()
        assertEquals(expected, ingredient.name)
    }

    @Test
    fun `test the second constructor works` () {
        assertTrue(ingredient2 is Ingredient)
        assertTrue(ingredient2.kilos > 0)
        println(ingredient2.kilos)
    }
}