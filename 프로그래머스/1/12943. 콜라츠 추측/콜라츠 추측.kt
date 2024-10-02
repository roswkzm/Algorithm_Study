class Solution {
    fun solution(num: Int): Int {
        var count = 0
        var currentNum = num.toLong()

        while (currentNum != 1L) {
            if (count >= 500) return -1
            currentNum = if (currentNum % 2 == 0L) currentNum / 2 else currentNum * 3 + 1
            count++
        }
        return count
    }
}