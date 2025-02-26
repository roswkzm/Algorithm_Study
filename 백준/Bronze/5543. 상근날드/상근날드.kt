import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val hamburgerList = mutableListOf<Int>()
    val drinkList = mutableListOf<Int>()

    repeat(5) {
        val price = br.readLine().toInt()
        if (it < 3) {
            hamburgerList.add(price)
        } else {
            drinkList.add(price)
        }
    }

    println(hamburgerList.minOf { it } + drinkList.minOf { it } - 50)
}
