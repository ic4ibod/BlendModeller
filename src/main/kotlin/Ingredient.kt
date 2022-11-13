import java.util.*

class Ingredient(name_param: String, kilos_param: Double ) {

    val name: String = name_param
        get() = field.uppercase(Locale.getDefault())

    var kilos: Double = kilos_param
        set(value) {
            if ((value > 0) && (value < 1000)) field = value
        }

    val percent: Double
        get() = kilos / 1000
}
