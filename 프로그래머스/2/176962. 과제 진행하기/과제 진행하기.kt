import java.util.PriorityQueue

class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val answer = mutableListOf<String>()

        fun timeToMinutes(time: String): Int {
            val (hour, minute) = time.split(":").map { it.toInt() }
            return hour * 60 + minute
        }

        val sortedPlans = plans.map { Triple(it[0], timeToMinutes(it[1]), it[2].toInt()) }
            .sortedBy { it.second }

        val pausedTasks = PriorityQueue(compareByDescending<Triple<String, Int, Int>> { it.second })

        var currentTime = 0

        for ((name, startTime, playtime) in sortedPlans) {
            // 기존 과제 처리
            while (pausedTasks.isNotEmpty() && currentTime < startTime) {
                val (pausedName, _, remainingTime) = pausedTasks.poll()!!
                if (currentTime + remainingTime <= startTime) {
                    currentTime += remainingTime
                    answer.add(pausedName)
                } else {
                    pausedTasks.add(Triple(pausedName, currentTime, remainingTime - (startTime - currentTime)))
                    currentTime = startTime
                    break
                }
            }

            currentTime = startTime
            if (currentTime + playtime <= startTime) {
                currentTime += playtime
                answer.add(name)
            } else {
                pausedTasks.add(Triple(name, currentTime, playtime))
            }
        }

        while (pausedTasks.isNotEmpty()) {
            val (pausedName, _, _) = pausedTasks.poll()!!
            answer.add(pausedName)
        }

        return answer.toTypedArray()
    }

}