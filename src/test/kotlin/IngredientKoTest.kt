import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.*
import io.kotest.matchers.doubles.shouldBeGreaterThan
import kotlin.random.Random

// TODO: Write tests for overloads

class IngredientKoTest : FunSpec() {

    init {

        test("test we can read values from an ingredient object") {
            val ingredient = Ingredient("N", 40.0)
            ingredient.value shouldBe 40.0
        }

        test("test we can geta percentage back"){
            val ingredient = Ingredient("n", 40.0)
            val percent: Double = 40.0 / 1000.0
            ingredient.percent shouldBe percent
        }

        test("test the random vaue generator constructor") {
            val random = Random(42).nextInt(15,20).toDouble()
            val ingredient = Ingredient("N", 15, 20, true)
            random shouldBe ingredient.value
        }

        test("test the constructur that accepts a list of values and works out the mean") {
            val nList: List<Double> = listOf(12.5, 34.6, 12.2, 34.2, 44.4)
            val nListAve = nList.average()
            nListAve shouldBe Ingredient("N", nList).value
        }

        test("test that the constructor that beuilds a proability distributionreturns a value") {
            Ingredient("N", 30.0, 4.0).value.shouldBeGreaterThan(0.0)
        }
    }
}
