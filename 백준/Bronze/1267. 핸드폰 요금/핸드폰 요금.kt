import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val callList = br.readLine().split(" ").map { it.toInt() }

    var yCost = 0
    var mCost = 0

    callList.forEach {
        yCost += (it / 30 + 1) * 10
        mCost += (it / 60 + 1) * 15
    }

    when {
        yCost < mCost -> println("Y $yCost")
        yCost > mCost -> println("M $mCost")
        else -> println("Y M $yCost")
    }
}