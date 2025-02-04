class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val remainingDays = progresses.mapIndexed { index, i -> 
            val day = (100 - i) / speeds[index]
            if ((100 - i) % speeds[index] > 0) day + 1 else day
        }
        
        val result = mutableListOf<Int>()
        var currentDay = remainingDays[0]
        var count = 0
        
        for (day in remainingDays) {
            if(day <= currentDay) {
                count++
            } else {
                result.add(count)
                currentDay = day
                count = 1
            }
        }
        result.add(count)
        
        return result.toIntArray()
    }
}