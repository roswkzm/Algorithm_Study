import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var five = n / 5
    var remain = n % 5

    while (five >= 0) {
        if (remain % 2 == 0) {
            println(five + remain / 2)
            return
        }
        five--
        remain += 5
    }

    println(-1)
}
