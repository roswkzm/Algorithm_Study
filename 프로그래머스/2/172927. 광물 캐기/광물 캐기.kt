class Solution {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer = 0
        val remainPicks = picks.toMutableList()

        val fiveBundleMinerals = minerals.toList().chunked(5)

        val processableBundles =
            fiveBundleMinerals.take(remainPicks.sumOf { it }).sortedByDescending {
                it.map {
                    when (it) {
                        "diamond" -> 25
                        "iron" -> 5
                        "stone" -> 1
                        else -> 0
                    }
                }.sumOf { it }
            }
        println(processableBundles)

        for (bundle in processableBundles) {
            if (remainPicks[0] > 0) {
                // 다이아 곡괭이 사용
                remainPicks[0] -= 1
                answer += bundle.map {
                    when (it) {
                        "diamond" -> 1
                        "iron" -> 1
                        "stone" -> 1
                        else -> 0
                    }
                }.sumOf { it }
            } else if (remainPicks[1] > 0) {
                // 철 곡괭이 사용
                remainPicks[1] -= 1
                answer += bundle.map {
                    when (it) {
                        "diamond" -> 5
                        "iron" -> 1
                        "stone" -> 1
                        else -> 0
                    }
                }.sumOf { it }
            } else if (remainPicks[2] > 0) {
                // 돌 곡괭이 사용
                remainPicks[2] -= 1
                answer += bundle.map {
                    when (it) {
                        "diamond" -> 25
                        "iron" -> 5
                        "stone" -> 1
                        else -> 0
                    }
                }.sumOf { it }
            }
        }

        return answer
    }
}
