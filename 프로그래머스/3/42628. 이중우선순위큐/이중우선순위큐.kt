import java.util.PriorityQueue

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val priorityQueue = PriorityQueue<Int>()
        val descendingPriorityQueue = PriorityQueue<Int>(compareByDescending { it })

        for (operation in operations) {
            val split = operation.split(" ")
            val commend = split[0]
            val num = split[1].toInt()

            when (commend) {
                "I" -> {
                    priorityQueue.add(num)
                    descendingPriorityQueue.add(num)
                }

                "D" -> {
                    if (num == 1) {
                        priorityQueue.remove(descendingPriorityQueue.poll())
                    } else if (num == -1) {
                        descendingPriorityQueue.remove(priorityQueue.poll())
                    }
                }
            }
        }

        return intArrayOf(descendingPriorityQueue.poll() ?: 0, priorityQueue.poll() ?: 0)
    }
}