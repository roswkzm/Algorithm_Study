import kotlin.math.max
class Solution {
fun solution(points: Array<IntArray>, routes: Array<IntArray>): Int {
    val MAX = 101
    var answer = 0
    val numRobots = routes.size

    val pointCoords = Array(points.size + 1) { Pair(0, 0) }

    // 포인트 좌표 설정
    for (i in points.indices) {
        val r = points[i][0]
        val c = points[i][1]
        pointCoords[i + 1] = Pair(r, c)
    }

    val robotPaths = Array(numRobots) { mutableListOf<Pair<Int, Int>>() }
    var maxTime = 0

    // 각 로봇의 경로 계산
    for (i in 0 until numRobots) {
        val route = routes[i]
        val path = mutableListOf<Pair<Int, Int>>()
        var currentR = pointCoords[route[0]].first
        var currentC = pointCoords[route[0]].second
        path.add(Pair(currentR, currentC))

        for (j in 1 until route.size) {
            val nextR = pointCoords[route[j]].first
            val nextC = pointCoords[route[j]].second

            while (currentR != nextR) {
                currentR += if (currentR < nextR) 1 else -1
                path.add(Pair(currentR, currentC))
            }

            while (currentC != nextC) {
                currentC += if (currentC < nextC) 1 else -1
                path.add(Pair(currentR, currentC))
            }
        }

        maxTime = max(maxTime, path.size)
        robotPaths[i] = path
    }

    // 충돌 위험 계산
    for (t in 0 until maxTime) {
        val grid = Array(MAX) { IntArray(MAX) }

        for (i in 0 until numRobots) {
            if (t < robotPaths[i].size) {
                val (r, c) = robotPaths[i][t]
                grid[r][c]++
            }
        }

        for (r in 1 until MAX) {
            for (c in 1 until MAX) {
                if (grid[r][c] >= 2) {
                    answer++
                }
            }
        }
    }

    return answer
}
}