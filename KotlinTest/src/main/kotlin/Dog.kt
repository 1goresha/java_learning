class Dog {
    var name: String? = null
        get() = field?.lowercase()?.replaceFirstChar { it.uppercase() }

    var age: Int = 0
        set(value) {
            if (value > 0) field = value
        }

    var weight: Int = 0
        set(value) {
            if (value > 0) field = value
        }
}