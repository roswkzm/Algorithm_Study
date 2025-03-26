var fib1Count = 0

fun fib(n: Int): Int {
    return if (n == 1 || n == 2) {
        fib1Count++
        1
    } else {
        fib(n - 1) + fib(n - 2)
    }
}

fun fibonacci(n: Int): Int {
    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 1
    var count = 0
    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
        count++
    }
    return count
}

fun main() {
    val n = readLine()!!.toInt()
    fib(n)
    val dpCount = fibonacci(n)
    println("$fib1Count $dpCount")
}
