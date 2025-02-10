import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    repeat(br.readLine()!!.toInt()) {
        val (a, b) = br.readLine()!!.split(" ").map{ it.toInt() }
        println(lcm(a, b))
    }
}

fun gcd(a: Int, b : Int) : Int {
    return if (b == 0) a else gcd(b, a % b)
}

fun lcm(a : Int, b : Int) : Int {
    return (a * b) / gcd(a, b)
}