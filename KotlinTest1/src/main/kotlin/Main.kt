fun main() {

    val string = readLine()
    var optionalString: String? = when(string){

        "1" -> "one"
        "2" -> "two"
        "3" -> "three"
        else -> null
    }

//    println(optionalString?: "WTF")
    optionalString?.let { println(it)}

    val a:Collection<String>
    a.joinToString()

}

