import java.util.PriorityQueue

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val bookMinute =
            book_time.map { timeToMinute(it[0]) to timeToMinute(it[1]) + 10 }.sortedBy { it.first }
        val rooms = PriorityQueue<Int>()

        for ((start, end) in bookMinute) {
            if (rooms.isNotEmpty() && rooms.peek()!! <= start) {
                rooms.poll()
            }
            rooms.add(end)
        }


        return rooms.size
    }

    fun timeToMinute(time: String): Int {
        val (hour, minute) = time.split(":").map { it.toInt() }
        return hour * 60 + minute
    }
}