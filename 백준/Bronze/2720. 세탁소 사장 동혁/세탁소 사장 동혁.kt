fun main() {
    val n = readLine()!!.toInt()
    val moneyList = listOf(25, 10, 5, 1)

    repeat(n) {
        val moneyCount = IntArray(4)
        var result = readLine()!!.toInt()
        for (i in moneyList.indices) {
            moneyCount[i] = result / moneyList[i]
            result %= moneyList[i]
        }
        println(moneyCount.joinToString(" "))
    }
}