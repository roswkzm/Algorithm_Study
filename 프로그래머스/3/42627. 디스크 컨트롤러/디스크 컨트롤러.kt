import java.util.PriorityQueue

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        val sortedJobs = jobs.sortedBy { it[0] }
        val priorityQueue = PriorityQueue<IntArray>(compareBy({ it[1] }, { it[0] }))

        var currentTime = 0
        var totalTurnaroundTime = 0
        var jobIndex = 0

        while (jobIndex < sortedJobs.size || priorityQueue.isNotEmpty()) {
            while (jobIndex < sortedJobs.size && sortedJobs[jobIndex][0] <= currentTime) {
                priorityQueue.add(sortedJobs[jobIndex])
                jobIndex++
            }

            if (priorityQueue.isNotEmpty()) {
                val (curStartTime, curSpanTime) = priorityQueue.poll()!!
                currentTime += curSpanTime
                totalTurnaroundTime += currentTime - curStartTime
            } else {
                currentTime = sortedJobs[jobIndex][0]
            }
        }

        return totalTurnaroundTime / jobs.size
    }
}