import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val minute = timeToMinute(br.readLine())
    println(earlyAlarm(minute))
}

fun timeToMinute(time: String): Int {
    val (hour, minute) = time.split(" ").map { it.toInt() }
    return hour * 60 + minute
}

fun earlyAlarm(minute: Int): String {
    val earlyTime = if (minute < 45) {
        minute + timeToMinute("24 00") - 45
    } else {
        minute - 45
    }
    return "${earlyTime / 60} ${earlyTime % 60}"
}