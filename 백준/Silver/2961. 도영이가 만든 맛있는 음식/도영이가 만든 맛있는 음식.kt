import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val ingredient = mutableListOf<Pair<Int, Int>>()
    val combinationIndex = mutableListOf<List<Int>>()
    val indexList = (0 until n).toList()
    var result = Int.MAX_VALUE

    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        ingredient.add(a to b)
    }

    fun backtrack(start: Int, curr: MutableList<Int>) {
        if (curr.isNotEmpty()) {
            combinationIndex.add(curr.toList())
        }

        for (i in start until indexList.size) {
            curr.add(indexList[i])
            backtrack(i + 1, curr)
            curr.removeLast()
        }
    }

    backtrack(0, mutableListOf())


    combinationIndex.forEach {
        val (a, b) = it.fold(1 to 0) { acc, i ->
            val currIngredient = ingredient[i]
            acc.first * currIngredient.first to acc.second + currIngredient.second
        }
        val diff = abs(a - b)
        result = minOf(result, diff)
    }

    println(result)
}