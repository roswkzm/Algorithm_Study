fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }

    var answer = -1
    for (k in 0..n) {
        val trueCount = arr.count { it == k }
        if (trueCount == k) {
            answer = maxOf(answer, k)
        }
    }
    println(answer)
}
