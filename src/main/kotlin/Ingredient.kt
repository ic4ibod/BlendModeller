import java.util.*
import kotlin.random.Random
import org.apache.commons.math3.distribution.NormalDistribution

// TODO: Convert to data class

/**
 * Class for Ingredient object that builds the Cube
 *
 * @param[name_param] The name of the ingredient, e.g., "Nitrogen"
 * @property[kilos] The number of kilos of the ingredient (can't be > 1000)
 * @constructor Creates an empty ingredient with name only
 */
data class Ingredient(override val key: String, override var value: Double): Map.Entry<String, Double> {

    val percent: Double
        get() = value / 1000

    /**
     * Instantiates an ingredient with a random kilo values
     *
     * @param[key_param] The name of th ingredient
     * @param[min_range] The minimum value used to define the random range
     * @param[max_range] The maximum value used to define the random range
     * @param[test] USed in testing. Sets random seed to 42
     */
    constructor(key_param: String, min_range: Int = 0, max_range: Int = 0, test:Boolean = false): this(key_param, 0.0) {
        when (test) {
            true -> this.value = Random(42).nextInt(min_range,max_range).toDouble()
            false ->this.value = Random.nextInt(min_range,max_range).toDouble()
        }
    }

    /**
     * Instantiates an ingredient object usng the mean of a list of weights
     *
     * @param[name_param] The name of the ingredient
     * @param[listOfVals] A list of weights (from analysis)
     */
    constructor(name_param: String, listOfVals: List<Double>): this(name_param, 0.0) {
        this.value = listOfVals.average()
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
        this.value = sample
    }


}
