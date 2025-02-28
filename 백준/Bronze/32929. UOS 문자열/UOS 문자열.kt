fun main() {
    val x = readLine()!!.toInt()
    val result = when (x % 3) {
        1 -> 'U'
        2 -> 'O'
        else -> 'S'
    }
    println(result)
}