import java.util.*
import kotlin.random.Random
import org.apache.commons.math3.distribution.NormalDistribution

/**
 * Class for Ingredient object that builds the Cube
 *
 * @param[name_param] The name of the ingredient, e.g., "Nitrogen"
 * @property[kilos] The number of kilos of the ingredient (can't be > 1000)
 * @constructor Creates an empty ingredient with name only
 */
class Ingredient(name_param: String) {
    val name: String = name_param
        get() = field.uppercase(Locale.getDefault())

    //TODO: What happens if the ingredient is more than 1000 kilos?
    var kilos: Double = 0.0
        set(value) {
            if ((value > 0) && (value < 1000)) field = value
        }

    /**
     * Instatiates ingredient with a set weight in kilos
     *
     * @param[kilos_param] The weight in kilos of the ingredient
     */
    constructor(name_param: String, kilos_param: Double): this(name_param) {
        this.kilos = kilos_param
    }

    val percent: Double
        get() = kilos / 1000

    /**
     * Instantiates an ingredient with a random kilo values
     *
     * @param[name_param] The name of th ingredient
     * @param[min_range] The minimum value used to define the random range
     * @param[max_range] The maximum value used to define the random range
     */
    constructor(name_param: String, min_range: Int = 0, max_range: Int = 0): this(name_param, 0.0) {
        this.kilos = Random.nextInt(min_range,max_range).toDouble()
    }

    /**
     * Instantiates an ingredient object usng the mean of a list of weights
     *
     * @param[name_param] The name of the ingredient
     * @param[listOfVals] A list of weights (from analysis)
     */
    constructor(name_param: String, listOfVals: List<Double>): this(name_param, 0.0) {
        this.kilos = listOfVals.average()
    }

    /**
     * Instantiates an ingredient object using a random value based on a normal probaility distribution
     *
     * @param[name_param] The name of the ingredient
     * @param[mean] The mean value for the probaility denisity function
     * @param[sdev] The standard deviation for the pdf
     */
    constructor(name_param: String, mean: Double = 0.0, sdev: Double = 1.0): this(name_param, 0.0) {
        val sample = NormalDistribution(mean, sdev).sample()
        this.kilos = sample
    }


}
