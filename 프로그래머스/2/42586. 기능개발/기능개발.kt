class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {

        val remainingDays = progresses.mapIndexed { index, progress ->
            val days = (100 - progress) / speeds[index]
            if ((100 - progress) % speeds[index] > 0) days + 1 else days
        }

        val result = mutableListOf<Int>()
        var currentMaxDay = remainingDays[0]
        var count = 0

        for (day in remainingDays) {
            if (day <= currentMaxDay) {
                count++
            } else {
                result.add(count)
                currentMaxDay = day
                count = 1
            }
        }
        result.add(count)

        return result.toIntArray()
    }
}