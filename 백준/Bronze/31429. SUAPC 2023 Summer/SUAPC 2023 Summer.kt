fun main() {
    val n = readLine()!!.toInt()

    val results = mapOf(
        1 to Pair(12, 1600),
        2 to Pair(11, 894),
        3 to Pair(11, 1327),
        4 to Pair(10, 1311),
        5 to Pair(9, 1004),
        6 to Pair(9, 1178),
        7 to Pair(9, 1357),
        8 to Pair(8, 837),
        9 to Pair(7, 1055),
        10 to Pair(6, 556),
        11 to Pair(6, 773)
    )

    val (problems, penalty) = results[n]!!
    println("$problems $penalty")
}
