import java.util.PriorityQueue

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val timeMap = book_time.map { timeToMinutes(it[0]) to timeToMinutes(it[1]) + 10 }.sortedBy { it.first }
        val rooms = PriorityQueue<Int>()

        for ((start, end) in timeMap) {

            if (rooms.isNotEmpty() && rooms.peek()!! <= start) {
                rooms.poll()
            }
            rooms.offer(end)
        }

        return rooms.size
    }

    private fun timeToMinutes(time: String): Int {
        val (hour, minute) = time.split(":").map { it.toInt() }
        return (hour * 60) + minute
    }
}