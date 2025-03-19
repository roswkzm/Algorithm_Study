fun main() {
    val k = readLine()!!.toInt()
    val stack = ArrayDeque<Int>()
    repeat(k) {
        val value = readLine()!!.toInt()
        if (value == 0) {
            stack.removeLast()
        } else {
            stack.addLast(value)
        }
    }
    println(stack.sum())
}