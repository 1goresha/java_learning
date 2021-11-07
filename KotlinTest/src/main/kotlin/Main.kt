fun main(args: Array<String>) {

    val str: String?
    str = null
    showStringLength(str)


}

fun showStringLength(str: String?){

    println(str?.length)
}
