fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1)

    repeat(n) {
        val (w, v) = readln().split(" ").map { it.toInt() }
        for (cap in k downTo w) {
            val nv = dp[cap - w] + v
            if (nv > dp[cap]) dp[cap] = nv
        }
    }
    println(dp[k])
}
