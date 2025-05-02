fun main() {
    val (n, a, b) = readLine()!!.split(" ").map { it.toInt() }
    var playerA = a
    var playerB = b
    var round = 0

    while (playerA != playerB) {
        playerA = (playerA + 1) / 2
        playerB = (playerB + 1) / 2
        round++
    }

    println(round)
}