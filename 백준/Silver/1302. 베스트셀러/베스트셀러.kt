fun main() {
    val n = readLine()!!.toInt()
    val map = mutableMapOf<String, Int>()

    repeat(n) {
        val title = readLine()!!
        map[title] = map.getOrDefault(title, 0) + 1
    }

    val max = map.values.maxOrNull()!!
    val candidates = map.filterValues { it == max }.keys
    println(candidates.minOrNull())
}