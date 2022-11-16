import java.util.*
import kotlin.random.Random

class Ingredient(name_param: String, kilos_param: Double ) {

    val name: String = name_param
        get() = field.uppercase(Locale.getDefault())
    var kilos: Double = kilos_param
        set(value) {
            if ((value > 0) && (value < 1000)) field = value
        }

    val percent: Double
        get() = kilos / 1000

    constructor(name_param: String, min_range: Int = 0, max_range: Int = 0): this(name_param, 0.0) {
        this.kilos = Random.nextInt(min_range,max_range).toDouble()
    }



}
