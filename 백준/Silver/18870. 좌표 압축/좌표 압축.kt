fun main() {
    val n = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map { it.toInt() }
    val changeValuePair = list.toSet().sorted().mapIndexed { index, i -> i to index }.toMap()
    println(list.map { changeValuePair.getValue(it) }.joinToString(" "))
}