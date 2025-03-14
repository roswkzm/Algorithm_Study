fun main() {
    var n = readLine()!!.toInt()
    var count = 0

    while (n >= 0) {
        if (n % 5 == 0) {
            count += n / 5
            println(count)
            return
        }
        n -= 3
        count++
    }

    println(-1)
}