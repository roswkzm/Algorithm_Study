fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val cardList = readLine()!!.split(" ").map { it.toInt() }
    var maxValue = Int.MIN_VALUE

    fun backtrack(start: Int, count: Int, sum: Int) {
        if (count == 3) {
            if (sum <= m) maxValue = maxOf(maxValue, sum)
            return
        }

        for (i in start until n) {
            if (sum + cardList[i] > m) continue
            backtrack(i + 1, count + 1, sum + cardList[i])
        }
    }

    backtrack(0, 0, 0)
    println(maxValue)
}