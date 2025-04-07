import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val pq = PriorityQueue<Int>(compareByDescending { it })

    repeat(n) {
        val x = readLine()!!.toInt()
        if (x == 0) {
            if (pq.isEmpty()) {
                println(0)
            } else {
                println(pq.poll())
            }
        } else {
            pq.add(x)
        }
    }
}