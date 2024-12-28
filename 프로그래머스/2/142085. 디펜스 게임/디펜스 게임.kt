import java.util.PriorityQueue

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer = 0

        fun canSolvedGame(stage: Int): Boolean {
            var remainingSoldiers = n
            var remainingShields = k
            val maxHeap = PriorityQueue<Int>(compareByDescending { it })

            for (curStage in 0 until stage) {
                maxHeap.add(enemy[curStage])
                remainingSoldiers -= enemy[curStage]

                if (remainingSoldiers < 0) {
                    if (remainingShields > 0) {
                        remainingSoldiers += maxHeap.poll()!!
                        remainingShields--
                    } else {
                        return false
                    }
                }
            }
            return true
        }

        var start = 0
        var end = enemy.size

        while (start <= end) {
            val mid = (start + end) / 2
            if (canSolvedGame(mid)) {
                start = mid + 1
                answer = mid
            } else {
                end = mid - 1
            }
        }

        return answer
    }
}