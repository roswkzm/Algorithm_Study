fun main() {
    val n = readLine()!!.toInt()
    val stairs = IntArray(n + 1)

    for (i in 1..n) {
        stairs[i] = readLine()!!.toInt()
    }

    if (n == 1) {
        println(stairs[1])
        return
    } else if (n == 2) {
        println(stairs[1] + stairs[2])
        return
    }

    val dp = IntArray(n + 1)
    dp[1] = stairs[1]
    dp[2] = stairs[1] + stairs[2]
    dp[3] = maxOf(stairs[1] + stairs[3], stairs[2] + stairs[3])

    for (i in 4..n) {
        dp[i] = maxOf(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i])
    }

    println(dp[n])
}
