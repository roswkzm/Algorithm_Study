fun main() {
    val (a, b, c, m) = readLine()!!.split(" ").map { it.toInt() }
    var fatigue = 0
    var result = 0
    var time = 0

    while (time < 24) {
        if (fatigue + a <= m) {
            fatigue += a
            result += b
        } else {
            fatigue = maxOf(0, fatigue - c)
        }
        time++
    }
    println(result)
}