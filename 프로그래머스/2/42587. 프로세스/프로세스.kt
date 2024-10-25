class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addAll(priorities.mapIndexed { index, priority -> priority to index })

        while (queue.isNotEmpty()) {
            val curProcess = queue.removeFirst()
            if (queue.any { it.first > curProcess.first }) {
                queue.add(curProcess)
            } else {
                answer++
                if (curProcess.second == location) {
                    return answer
                }
            }
        }

        return answer
    }
}