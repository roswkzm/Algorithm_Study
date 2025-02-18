import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    val (a, b) = br.readLine().split(" ").map{ it.toLong() }
    println(lcm(a, b))
}

fun gcd(a : Long, b : Long) : Long {
    return if(b == 0L) a else gcd(b, a % b)
}

fun lcm(a : Long, b : Long) : Long {
    return (a * b) / gcd(a, b)
}