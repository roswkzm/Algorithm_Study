fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val wordList = mutableListOf<String>()
    repeat(n) {
        val word = readLine()!!
        if (word.length >= m) {
            wordList.add(word)
        }
    }

    val result = wordList.groupBy { it }.mapValues { it.value.size }
        .toList().sortedWith(
            compareByDescending<Pair<String, Int>> { it.second }
                .thenByDescending { it.first.length }
                .thenBy { it.first }
        ).map { it.first }
    println(result.joinToString("\n"))
}