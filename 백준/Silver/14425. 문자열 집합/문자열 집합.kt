fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val findWords = mutableSetOf<String>()
    repeat(n) { findWords.add(readLine()!!) }

    var count = 0
    repeat(m) {
        if (readLine()!! in findWords) count++ // O(1) 탐색
    }
    println(count)
}