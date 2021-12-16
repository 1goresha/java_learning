class Programmer(name: String, age: Int, val language: String): Worker(name, age), Cleaner {
    override fun work() {
        println("i am programming on $language")
    }

    override fun clean() {
        println("i am programmer and i have to clean up my workplace sometimes")
    }
}