fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(n) { readLine()!!.toCharArray() }
    var count = 0

    for (i in 0 until n) {
        var j = 0
        while (j < m) {
            if (map[i][j] == '-') {
                count++
                while (j < m && map[i][j] == '-') {
                    j++
                }
            } else {
                j++
            }
        }
    }

    for (j in 0 until m) {
        var i = 0
        while (i < n) {
            if (map[i][j] == '|') {
                count++
                while (i < n && map[i][j] == '|') {
                    i++
                }
            } else {
                i++
            }
        }
    }

    println(count)
}
