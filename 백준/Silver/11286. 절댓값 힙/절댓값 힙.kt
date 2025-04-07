import java.util.*
import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })

    repeat(n) {
        val x = readLine()!!.toInt()
        if (x == 0) {
            if (pq.isEmpty()) {
                println(0)
            } else {
                println(pq.poll().first)
            }
        } else {
            pq.add(x to abs(x))
        }
    }
}