fun main() {
    val n = readLine()!!.toInt()
    var minValue = Int.MAX_VALUE

    for (i in 1 until n) {
        var result = i
        var remainNumber = i
        while (remainNumber != 0) {
            result += remainNumber % 10
            remainNumber /= 10
        }
        if (result == n) {
            minValue = minOf(minValue, i)
        }
    }

    println(if (minValue == Int.MAX_VALUE) "0" else minValue)
}