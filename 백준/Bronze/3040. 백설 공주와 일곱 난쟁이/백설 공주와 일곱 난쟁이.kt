import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numberList = mutableListOf<Int>()
    repeat(9) {
        val number = br.readLine().toInt()
        numberList.add(number)
    }
    var result = listOf<Int>()

    fun backTrack(start: Int, curr: MutableList<Int>) {
        if (curr.size == 7) {
            if (curr.sum() == 100) {
                result = curr.toList()
            }
            return
        }
        for (i in start until numberList.size) {
            curr.add(numberList[i])
            backTrack(i + 1, curr)
            curr.removeLast()

        }
    }

    backTrack(0, mutableListOf())

    result.forEach {
        println(it)
    }
}