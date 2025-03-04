import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val x = br.readLine().toInt()
    val n = br.readLine().toInt()
    var totalMoney = 0
    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        totalMoney += a * b
    }
    if (totalMoney == x) {
        println("Yes")
    } else {
        println("No")
    }
}