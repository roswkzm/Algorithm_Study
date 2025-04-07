import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val pq = PriorityQueue<Int>(compareByDescending { it })

    repeat(n) {
        val nums = readLine()!!.split(" ").map { it.toInt() }
        pq.addAll(nums)
    }

    repeat(n - 1) {
        pq.poll()
    }

    println(pq.poll())
}