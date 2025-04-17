fun main() {
    val n = readln().toInt()
    val input = readln().split(" ").map { it.toInt() }
    val result = MutableList(n) { 0 }

    for (i in 0 until n) {
        var count = 0
        for (j in 0 until n) {
            if (result[j] == 0) {
                if (count == input[i]) {
                    result[j] = i + 1
                    break
                }
                count++
            }
        }
    }

    println(result.joinToString(" "))
}