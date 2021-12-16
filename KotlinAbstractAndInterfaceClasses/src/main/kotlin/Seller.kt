class Seller(name: String, age: Int): Worker(name, age), Cleaner {
    override fun work() {
        println("i am selling a goods")
    }

    override fun clean() {
        println("i am seller and i have to clean up my workplace sometimes")
    }
}