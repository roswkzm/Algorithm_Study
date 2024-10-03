class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val mutableMap = mutableMapOf(
            "R" to 0,
            "T" to 0,
            "C" to 0,
            "F" to 0,
            "J" to 0,
            "M" to 0,
            "A" to 0,
            "N" to 0
        )

        for ((idx, value) in choices.withIndex()) {
            when (value) {
                1, 2, 3 -> {
                    val key = survey[idx][0].toString()
                    mutableMap[key] = mutableMap.getValue(key) + (4 - value)
                }

                5, 6, 7 -> {
                    val key = survey[idx][1].toString()
                    mutableMap[key] = mutableMap.getValue(key) + (value - 4)
                }
            }
        }

        val sb = StringBuilder()
        val answer: String = with(sb) {
            append(if (mutableMap.getValue("R") < mutableMap.getValue("T")) "T" else "R")
            append(if (mutableMap.getValue("C") < mutableMap.getValue("F")) "F" else "C")
            append(if (mutableMap.getValue("J") < mutableMap.getValue("M")) "M" else "J")
            append(if (mutableMap.getValue("A") < mutableMap.getValue("N")) "N" else "A")
        }.toString()

        return answer
    }
}