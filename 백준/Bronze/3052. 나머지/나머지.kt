fun main() {
    val numberSet = mutableSetOf<Int>()
    repeat(10) {
        val number = readLine()!!.toInt()
        numberSet.add(number % 42)
    }
    println(numberSet.size)
}