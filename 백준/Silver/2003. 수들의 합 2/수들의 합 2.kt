fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }

    var count = 0
    var sum = 0
    var start = 0
    var end = 0

    while (true) {
        if (sum >= m) {
            sum -= arr[start++]
        } else if (end == n) {
            break
        } else {
            sum += arr[end++]
        }

        if (sum == m) count++
    }

    println(count)
}
