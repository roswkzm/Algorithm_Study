import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sum = 0
    
    repeat(5) {
        val score = br.readLine().toInt()
        sum += if(score >= 40) score else 40
    }
    
    println(sum / 5)
}