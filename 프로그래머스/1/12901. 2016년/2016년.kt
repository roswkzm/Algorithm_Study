import java.time.LocalDate

class Solution {
    fun solution(a: Int, b: Int): String {
        val dayOfWeekName = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
        return dayOfWeekName[LocalDate.of(2016, a, b).dayOfWeek.value % 7]
    }
}