class Solution {
    fun solution(s: String): IntArray {
        var repeatCount = 0
        var removeZeroCount = 0
        var x: String = s
        
        while (x != "1") {
            repeatCount++
            removeZeroCount += x.count { it == '0' }
            x = x.filter { it != '0' }.length.toString(2)
        }
        return intArrayOf(repeatCount, removeZeroCount)
    }
}