import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val houseList = mutableListOf<Pair<Int, Int>>()
    val chickenList = mutableListOf<Pair<Int, Int>>()

    for (row in 0 until n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        line.forEachIndexed { col, j ->
            when (j) {
                1 -> houseList.add(row to col)
                2 -> chickenList.add(row to col)
            }
        }
    }

    val combinationChickenList = combination(chickenList, m)
    var minCityChickenDistance = Int.MAX_VALUE

    for (combineChickenList in combinationChickenList) {
        var cityChickenDistance = 0
        for ((hr, hc) in houseList) {
            var minDistance = Int.MAX_VALUE
            for ((cr, cc) in combineChickenList) {
                minDistance = minOf(minDistance, abs(hr - cr) + abs(hc - cc))
            }
            cityChickenDistance += minDistance
        }
        minCityChickenDistance = minOf(minCityChickenDistance, cityChickenDistance)
    }

    println(minCityChickenDistance)
}

fun combination(chickenList: MutableList<Pair<Int, Int>>, k: Int): List<List<Pair<Int, Int>>> {
    val result = mutableListOf<List<Pair<Int, Int>>>()

    fun backtrack(startIndex: Int, curr: MutableList<Pair<Int, Int>>) {
        if (curr.size == k) {
            result.add(curr.toList())
            return
        }
        for (i in startIndex until chickenList.size) {
            curr.add(chickenList[i])
            backtrack(i + 1, curr)
            curr.removeLast()
        }
    }

    backtrack(0, mutableListOf())

    return result
}