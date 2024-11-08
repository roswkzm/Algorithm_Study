class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        val results = mutableListOf<Int>()

        places.forEach {
            if (isSafe(it)) {
                results.add(1)
            } else {
                results.add(0)
            }
        }
        return results.toIntArray()
    }

    private fun isSafe(place: Array<String>): Boolean {
        for (i in place.indices) {
            for (j in place[i].indices) {
                if (place[i][j] == 'P') {
                    if (!checkDistance(place, i, j)) return false
                }
            }
        }
        return true
    }

    private fun checkDistance(place: Array<String>, x: Int, y: Int): Boolean {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = Array(5) { BooleanArray(5) }
        val moveList = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        queue.add(Pair(x, y))
        visited[x][y] = true

        var distance = 0

        while (queue.isNotEmpty()) {
            distance++
            if (distance > 2) break

            repeat(queue.size) {
                val (cx, cy) = queue.removeFirst()

                for ((dx, dy) in moveList) {
                    val nx = cx + dx
                    val ny = cy + dy

                    if (nx in 0..4 && ny in 0..4 && !visited[nx][ny]) {
                        visited[nx][ny] = true

                        when (place[nx][ny]) {
                            'P' -> return false  // 다른 응시자가 발견되면 거리두기 실패
                            'O' -> queue.add(Pair(nx, ny))  // 빈 테이블인 경우 계속 탐색
                        }
                    }
                }
            }
        }
        return true
    }
}