import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val(n ,m) = br.readLine().split(" ").map{ it.toInt() }
    val numberList = br.readLine().split(" ").map{ it.toInt() }.sorted()
    val numberSet = mutableSetOf<List<Int>>()

    fun backtrack(start : Int, curr : MutableList<Int>) {
        if(curr.size == m) {
            numberSet.add(curr.toList())
        }
        for(i in start until numberList.size) {
            curr.add(numberList[i])
            backtrack(i + 1, curr)
            curr.removeLast()
        }
    }

    backtrack(0, mutableListOf())

    numberSet.forEach {
        println(it.joinToString(" "))
    }
}