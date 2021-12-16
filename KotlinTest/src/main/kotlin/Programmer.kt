class Programmer(name: String, age: Int, val language: String): Worker(name, age) {
    override fun work() {
        println("i programming using $language")
    }
}