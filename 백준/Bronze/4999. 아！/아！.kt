import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    val my = br.readLine()
    val doctor = br.readLine()
    
    if(my.length >= doctor.length) {
        println("go")
    } else {
        println("no")
    }
}