fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        repeat(m) { readln() }
        sb.append(n - 1).append('\n')
    }
    print(sb)
}
