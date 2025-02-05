import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val locationPriorities = priorities.mapIndexed{ index, i -> index to i}
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addAll(locationPriorities)

        while (queue.isNotEmpty()){
            val currTask = queue.pop()

            if (queue.any { it.second > currTask.second }){
                queue.add(currTask)
                continue
            } else {
                answer ++
            }

            if (currTask.first == location) {
                return answer
            }
        }

        return answer
    }
}