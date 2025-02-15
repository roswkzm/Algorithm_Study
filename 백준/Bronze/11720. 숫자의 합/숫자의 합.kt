import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val numberList = br.readLine().map { it.digitToInt() }
    println(numberList.reduce { acc, i -> acc + i })
}
