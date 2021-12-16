val array: MutableList<Int>? = mutableListOf()

fun main(args: Array<String>) {

//    array?.let {
//        with(it) {
//            for (i in 0..1000) {
//                add((Math.random() * 100).toInt())
//            }
//
//            filter { it % 2 == 0 }.take(100).forEach { println(it) }
//        }
//    }

    val intArray = (0..99).toList()
    val names = listOf<String>("Alex", "Andrew", "Maxim", "Fedor", "Masha", "Michel", "Artem", "Natasha", "Igor")
//    val changedInt = intArray.map { a: Int -> a * 2 }
//    val changedInt = intArray.filter { it % 2 == 0 }
//    val changedString = names.filter { it.contains("a", true) && it.length <=5 }
//    changedString.forEach { println(it) }

//    val perimeter: (Int, Int) -> Int = {a,b -> a * b}
//    println(perimeter(10,2))

//    val sayHello: (String) -> Unit = { println("hello $it")}
//    sayHello("Igor")
//
//    val sortArray: (Array<Int>) -> Array<Int> = {array: Array<Int> ->
//        for (i in array.size - 2 downTo 0){
//            for (j in 0..i){
//                if (array[j] < array[j+1]){
//                    val temp = array[j]
//                    array[j] = array[j+1]
//                    array[j+1] = temp
//                }
//            }
//        }
//        array
//    }
//
//    val array = arrayOf(3,1,-5, 55, 4, 8, 5, -155)
//    sortArray(array).forEach { println(it) }

//    val newArray = names.filter { it.startsWith("A") }
//    newArray.forEach { println(it) }

//    val randomIntArray = mutableListOf<Int>()
//    for (i in 0 until 1000) {
//        randomIntArray.add((Math.random() * 1000).toInt())
//    }
//
//    val newArray = randomIntArray.filter { it % 3 == 0 && it % 5 == 0 }.map { it * it }.sortedDescending().map { it.toString() }
//    newArray.forEach { println(it) }

//    val array = generateSequence("сотрудник є1") {
//        val index = it.substring(11).toInt()
//        "сотрудник є${index + 1}"
//    }
//
//    val takeFirst100 = array.take(100)
//    takeFirst100.forEach { println(it) }
//
//    val arrayNames = mutableListOf<String>()
//    val arrayTelephoneNumbers = mutableListOf<Long>()
//
//    for (an in 0..1000) {
//
//        arrayNames.add("»м€ $an")
//    }
//
//    for (at in 0..1000) {
//
//        arrayTelephoneNumbers.add((79_000_000_000 + Math.random() * 1_000_000_000).toLong())
//    }
//
//    val newArray = arrayNames.zip(arrayTelephoneNumbers)
//
//    newArray.forEach { println(it) }

    val data = mapOf(
        "январь" to listOf(100, 100, 100, 100),
        "‘евраль" to listOf(200, 200, -190, 200),
        "ћарт" to listOf(300, 180, 300, 100),
        "јпрель" to listOf(250, -250, 100, 300),
        "ћай" to listOf(200, 100, 400, 300),
        "»юнь" to listOf(200, 100, 300, 300)
    )

//    printInfo(data)

//    val str: String? = "hello"
//    str?.let {
//        if (it.length > 1) {
//            println("word")
//        }
//    }

//    val newModifyString = modifyString("hello world") {it.uppercase()}
//    println(newModifyString)

//    val numList = (0..100).toList()
//    doMathOperationWithNumList(numList) { println(it.sum()) }

//    val tempIntNum = 10
//    println(tempIntNum.isPrime())
//
//    println(11.isPrime())
//
//    val str = "hello world"
//    myWith(str){
//        length
//        println(substring(0..2))
//    }

    val dog = Dog()
    dog.name = "рекс"
    dog.age = -11
    dog.weight = 40

    println("собаку зовут ${dog.name} , ему ${dog.age} лет, он весит целых ${dog.weight} килограмм")

    val barsik = Cat("Ѕарсик", age = 8)
    println(barsik.isOld)
    val student = Student("»ван", "»ванов", 20)
    val(name, _, age) = student
    println(name)
//    println(lastName)
    println(age)


    val worker1 = Worker("Kostantin", 29)
    val worker2 = Worker("Eduard", 47)
    val worker3 = Worker("Dmitriy", 30)
    val programmer1 = Programmer("Igor", 32, "Kotlin")
    val programmer2 = Programmer("Michel", 37, "Java")
    val programmer3 = Programmer("Stepan", 33, "Python")

    val list = mutableListOf<Worker>()
    list.add(worker1)
    list.add(worker2)
    list.add(worker3)
    list.add(programmer1)
    list.add(programmer2)
    list.add(programmer3)

    list.forEach { it.work() }
}

fun printInfo(data: Map<String, List<Int>>) {
    val validData = data.filterNot { it.value.any { it < 0 } }
    val averageWeekData = validData.flatMap { it.value }.average()
    println("средн€€ еженедельна€ выручка = $averageWeekData")
    val sum = validData.map { it.value.sum() }
    val average = sum.average()
    println("средн€€ выручка за все мес€цы = $average")
    val max = sum.maxOrNull()
    val min = sum.minOrNull()

    val monthMax = validData.filter { it.value.sum() == max }.keys
    println("мес€цы с максимальной выручкой:")
    for (month in monthMax) {
        println(" $month")
    }

    val monthMin = validData.filter { it.value.sum() == min }.keys
    println("мес€цы с минимальной выручкой:")
    for (month in monthMin) {
        println(" $month")
    }
    val monthWithError = data.filter { it.value.any { it < 0 } }
    println("мес€цы с ошибками в данных:")
    for (month in monthWithError) {
        println(month.key)
    }

}

fun modifyString(str: String, modify: (String) -> String): String {
    return modify(str)
}

fun doMathOperationWithNumList(numList: List<Int>, mathOperation: (List<Int>) -> Unit): Unit {
    mathOperation(numList)
}

fun Int.isPrime(): Boolean {
    if (this <= 3) return true
    for (i in 2 until this) {
        if (this % i == 0) return false
    }
    return true
}

inline fun <T, R> myWith(obj: T, operation: T.() -> R): R {
    return obj.operation()
}



