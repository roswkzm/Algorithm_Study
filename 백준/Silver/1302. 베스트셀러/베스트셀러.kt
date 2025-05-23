fun main() {
    val n = readln().toInt()
    val bookCount = mutableMapOf<String, Int>()

    repeat(n) {
        val title = readln()
        bookCount[title] = bookCount.getOrDefault(title, 0) + 1
    }

    val maxCount = bookCount.values.maxOrNull() ?: 0
    val bestSellers = bookCount.filterValues { it == maxCount }.keys
    println(bestSellers.minOrNull())
}
