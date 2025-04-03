fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val nums = readLine()!!.split(" ").map { it.toLong() }

    val modCount = LongArray(m) { 0 }
    var sum = 0L
    var result = 0L

    for (num in nums) {
        sum = (sum + num) % m
        if (sum == 0L) result++
        modCount[sum.toInt()]++
    }

    for (count in modCount) {
        if (count >= 2) {
            result += count * (count - 1) / 2
        }
    }

    println(result)
}