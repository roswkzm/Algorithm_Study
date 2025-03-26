class Solution {
    fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
        var answer: Int = 0
        val candidateKeys = combination((1..n).toList(), 5)

        for (candidateKey in candidateKeys) {
            var isKey = true
            for (i in q.indices) {
                val currentCount = candidateKey.count { it in q[i] }
                if (currentCount != ans[i]) {
                    isKey = false
                    break
                }
            }
            if (isKey) answer++
        }

        return answer
    }

    fun combination(nums: List<Int>, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun backtrack(start: Int, curr: MutableList<Int>) {
            if (curr.size == k) {
                result.add(curr.toList())
                return
            }

            for (i in start until nums.size) {
                curr.add(nums[i])
                backtrack(i + 1, curr)
                curr.removeLast()
            }
        }
        backtrack(0, mutableListOf())
        return result
    }
}