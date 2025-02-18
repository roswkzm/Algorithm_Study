import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var remainMoney = 1000 - br.readLine().toInt()
    val moneyList = mutableListOf<Int>(500, 100, 50, 10, 5, 1)
    var moneyCount = 0
    
    for(n in moneyList) {
        moneyCount += (remainMoney / n)
        remainMoney = remainMoney % n
    }
    
    println(moneyCount)
}