fun main() {
    var count = 0

    for (i in 0 until 8) {
        val line = readLine()!!
        for (j in 0 until 8) {
            if ((i + j) % 2 == 0 && line[j] == 'F') {
                count++
            }
        }
    }

    println(count)
}
