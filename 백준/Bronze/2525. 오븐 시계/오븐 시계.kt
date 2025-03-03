import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (hour, minute) = br.readLine().split(" ").map { it.toInt() }
    val ovenTime = br.readLine().toInt()
    val totalMinute = hour * 60 + minute + ovenTime

    if (totalMinute < 1440) {
        println("${totalMinute / 60} ${totalMinute % 60}")
    } else {
        val remainMinute = totalMinute - 1440
        println("${remainMinute / 60} ${remainMinute % 60}")
    }
}