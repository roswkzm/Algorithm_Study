fun main() {
    val n = readln().trim().toInt()
    val cost = Array(n) { readln().trim().split(" ").map { it.toInt() }.toIntArray() }
    val size = 1 shl n
    val inf = Int.MAX_VALUE / 4
    val dp = IntArray(size) { inf }
    dp[0] = 0
    for (mask in 0 until size) {
        val i = Integer.bitCount(mask)
        if (i >= n) continue
        val base = dp[mask]
        if (base == inf) continue
        for (j in 0 until n) {
            if ((mask and (1 shl j)) == 0) {
                val next = mask or (1 shl j)
                val v = base + cost[i][j]
                if (v < dp[next]) dp[next] = v
            }
        }
    }
    println(dp[size - 1])
}
