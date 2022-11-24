import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

// TODO: Write tests for overloads

class IngredientKoTest : FunSpec() {

    init {
        test("test we can read values from an ingredient object") {
            val ingredient = Ingredient("N", 40.0)
            ingredient.kilos shouldBe 40.0
        }
    }
}
