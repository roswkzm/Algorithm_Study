fun main() {
    val input = readLine()!!.toInt()
    var num = input
    var count = 0

    do {
        val sum = (num / 10) + (num % 10)
        num = (num % 10) * 10 + (sum % 10)
        count++
    } while (num != input)

    println(count)
}
