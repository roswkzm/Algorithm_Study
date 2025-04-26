fun main() {
    val (x, y, p1, p2) = readLine()!!.split(" ").map { it.toInt() }
    var a = p1
    var b = p2

    repeat(1000000) {
        when {
            a < b -> a += x
            b < a -> b += y
            else -> {
                println(a)
                return
            }
        }
    }

    println(-1)
}
