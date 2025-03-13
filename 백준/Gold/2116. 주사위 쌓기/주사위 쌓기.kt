fun main() {
    val dices = mutableListOf<List<Int>>()
    val n = readLine()!!.toInt()
    var maxValue = 0

    repeat(n) {
        val dice = readLine()!!.split(" ").map { it.toInt() }
        dices.add(dice)
    }

    val opposite = mapOf(0 to 5, 1 to 3, 2 to 4, 3 to 1, 4 to 2, 5 to 0)

    fun deleteNumberDice(dice: List<Int>, index: Int): List<Int> {
        return dice.filterIndexed { idx, _ -> idx != index && idx != opposite[index] }
    }

    fun findDiceTopNumber(dice: List<Int>, beforeTopNumber: Int): Int {
        val bottomIndex = dice.indexOf(beforeTopNumber)
        return dice[opposite[bottomIndex]!!]
    }

    repeat(6) { i ->
        val newDicesList = mutableListOf<List<Int>>()
        var beforeDiceTopNumber = dices[0][opposite[i]!!]
        newDicesList.add(deleteNumberDice(dices[0], i))

        for (j in 1 until n) {
            beforeDiceTopNumber = findDiceTopNumber(dices[j], beforeDiceTopNumber)
            newDicesList.add(deleteNumberDice(dices[j], dices[j].indexOf(beforeDiceTopNumber)))
        }

        val currentDiceMaxValue = newDicesList.sumOf { dice -> dice.maxOrNull()!! }
        maxValue = maxOf(maxValue, currentDiceMaxValue)
    }

    println(maxValue)
}
