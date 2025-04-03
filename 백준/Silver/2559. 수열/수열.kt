fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val temps = readLine()!!.split(" ").map { it.toInt() }

    var sum = temps.take(k).sum()
    var maxSum = sum

    for (i in k until n) {
        sum = sum - temps[i - k] + temps[i]
        maxSum = maxOf(maxSum, sum)
    }

    println(maxSum)
}