import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val board = Array(n) { readLine()!!.split(" ").map { it.toInt() } }
    var minValue = Int.MAX_VALUE

    fun calcTeamDifference(teamList: List<Int>): Int {
        val teamAIndex = teamList.map { it - 1 }
        val teamBIndex = (1..n).filterNot { it in teamList }.map { it - 1 }
        var teamAScore = 0
        var teamBScore = 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i in teamAIndex && j in teamAIndex) {
                    teamAScore += board[i][j]
                }
                if (i in teamBIndex && j in teamBIndex) {
                    teamBScore += board[i][j]
                }
            }
        }
        return abs(teamAScore - teamBScore)
    }

    fun dfs(start: Int, currTeam: MutableList<Int>) {
        if (currTeam.size == n / 2) {
            val teamDiffScore = calcTeamDifference(currTeam.toList())
            minValue = minOf(minValue, teamDiffScore)
            return
        }

        for (i in start..n) {
            if (i !in currTeam) {
                currTeam.add(i)
                dfs(i + 1, currTeam)
                currTeam.removeLast()
            }
        }
    }

    dfs(1, mutableListOf())

    println(minValue)
}