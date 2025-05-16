fun main() {
    val n = readln().toInt()
    val p = readln().split(" ").map { it.toInt() }
    val s = readln().split(" ").map { it.toInt() }

    val initial = List(n) { it }
    var current = initial.toMutableList()
    var count = 0

    fun isTarget(): Boolean {
        return current.withIndex().all { (i, card) -> p[card] == i % 3 }
    }

    while (true) {
        if (isTarget()) {
            println(count)
            return
        }

        val next = MutableList(n) { 0 }
        for (i in 0 until n) {
            next[s[i]] = current[i]
        }

        current = next
        count++

        if (current == initial) {
            println(-1)
            return
        }
    }
}
