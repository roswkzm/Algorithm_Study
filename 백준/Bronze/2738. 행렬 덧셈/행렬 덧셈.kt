fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val array = Array(n) { IntArray(m) }
    repeat(n * 2) {
        val rowIndex = it % n
        val result = readLine()!!.split(" ").map { it.toInt() }
        array[rowIndex] = array[rowIndex].mapIndexed { index, i -> i + result[index] }.toIntArray()
    }
    array.forEach {
        println(it.joinToString(" "))
    }
}