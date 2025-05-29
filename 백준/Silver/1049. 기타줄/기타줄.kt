fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val prices = List(m) {
        val (pack, each) = readLine()!!.split(" ").map { it.toInt() }
        pack to each
    }

    val minPack = prices.minOf { it.first }
    val minEach = prices.minOf { it.second }

    val cost1 = (n / 6) * minPack + (n % 6) * minEach
    val cost2 = ((n + 5) / 6) * minPack
    val cost3 = n * minEach

    println(minOf(cost1, cost2, cost3))
}
