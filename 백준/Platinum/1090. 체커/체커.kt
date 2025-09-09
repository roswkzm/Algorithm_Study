import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val xs = IntArray(n)
    val ys = IntArray(n)

    repeat(n) { i ->
        val (x, y) = readln().split(" ").map { it.toInt() }
        xs[i] = x
        ys[i] = y
    }

    val result = IntArray(n) { Int.MAX_VALUE }

    for (tx in xs) {
        for (ty in ys) {
            val dist = IntArray(n)
            for (i in 0 until n) {
                dist[i] = abs(xs[i] - tx) + abs(ys[i] - ty)
            }
            dist.sort()
            var sum = 0
            for (k in 0 until n) {
                sum += dist[k]
                result[k] = minOf(result[k], sum)
            }
        }
    }

    println(result.joinToString(" "))
}
