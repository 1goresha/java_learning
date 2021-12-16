fun main() {

//val list = mutableListOf<Worker>()
//    list.add(Programmer("Igor", 32, "Kotlin"))
//    list.add(Programmer("Konstantin", 42, "Java"))
//    list.add(Seller("Michel", 22))
//    list.add(Seller("Eduard", 29))
//    list.add(Director("Valentin", 49))
//    list.forEach {
//        if (it is Director)
//            it.work()
//        if (it is Cleaner)
//            it.clean()
//        if (it is Programmer)
//            println(it.language)
//    }

//    val listOfWorkers = mutableListOf<Worker>()
//    listOfWorkers.add(Programmer("worker1", 25, "java"))
//    listOfWorkers.add(Programmer("worker2", 26, "kotlin"))
//    listOfWorkers.add(Director("director1", 27))
//    listOfWorkers.add(Director("director2", 32))
//    listOfWorkers.add(Seller("seller1", 36))
//    listOfWorkers.add(Seller("seller2", 29))
//    val listOfCleaners = listOfWorkers.filter { it is Cleaner }.map { it as Cleaner }
//    for (cleaner in listOfCleaners){
//        cleaner.clean()
//    }

val sportsman = Sportsman()
//    sportsman.invokeWaterBoy(object : WaterBoy{
//        override fun bringWater() {
//            println("he has brought a water to sportsmen")
//        }
//    })

//    sportsman.invokeWaterBoy {
//        println("he has brought a water to sportsman")
//        println("and some food")
//        println("and something else")
//    }

    println(Calc.lengthOfCircle(5f))
}