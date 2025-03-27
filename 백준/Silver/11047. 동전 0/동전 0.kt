fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val coins = IntArray(n) { readLine()!!.toInt() }
    var remainMoney = k
    var result = 0

    for (i in n - 1 downTo 0) {
        result += remainMoney / coins[i]
        remainMoney %= coins[i]
    }

    println(result)
}