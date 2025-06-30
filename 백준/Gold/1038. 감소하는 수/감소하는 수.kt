fun main() {
    val n = readLine()!!.toInt()
    val result = mutableListOf<Long>()

    fun dfs(num: Long, lastDigit: Int) {
        result.add(num)
        for (i in 0 until lastDigit) {
            dfs(num * 10 + i, i)
        }
    }

    for (i in 0..9) {
        dfs(i.toLong(), i)
    }

    result.sort()
    if (n >= result.size) {
        println(-1)
    } else {
        println(result[n])
    }
}
