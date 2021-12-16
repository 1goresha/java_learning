class Cat(val name: String?, var age: Int = 0, var weight: Int = 0) {

    val isOld: Boolean
    get() = age > 7

}