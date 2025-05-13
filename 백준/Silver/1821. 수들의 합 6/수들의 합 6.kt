import kotlin.system.exitProcess

lateinit var comb: Array<IntArray>
lateinit var used: BooleanArray
lateinit var result: IntArray
var n = 0
var f = 0

fun main() {
    val (nn, ff) = readLine()!!.split(" ").map { it.toInt() }
    n = nn
    f = ff
    comb = Array(n) { IntArray(n) }
    used = BooleanArray(n + 1)
    result = IntArray(n)

    // 조합 수 미리 계산
    for (i in 0 until n) {
        for (j in 0..i) {
            comb[i][j] = if (j == 0 || j == i) 1 else comb[i - 1][j - 1] + comb[i - 1][j]
        }
    }

    dfs(0, 0)
}

fun dfs(level: Int, sum: Int) {
    if (level == n) {
        if (sum == f) {
            println(result.joinToString(" "))
            exitProcess(0)
        }
        return
    }

    for (i in 1..n) {
        if (!used[i]) {
            used[i] = true
            result[level] = i
            dfs(level + 1, sum + i * comb[n - 1][level])
            used[i] = false
        }
    }
}
