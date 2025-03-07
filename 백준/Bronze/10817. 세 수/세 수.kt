fun main() {
    val list = readLine()!!.split(" ").map { it.toInt() }.sorted()
    println(list[1])
}