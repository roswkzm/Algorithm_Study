import kotlin.math.max
import kotlin.math.min

class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        min(a,b).rangeTo(max(a,b)).map { answer += it }
        return answer
    }
}