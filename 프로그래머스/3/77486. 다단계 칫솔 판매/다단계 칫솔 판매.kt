class Solution {
    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        val earnings = IntArray(enroll.size)
        val parentMap = mutableMapOf<String, String>()
        val indexMap = enroll.withIndex().associate { it.value to it.index }

        for (i in enroll.indices) {
            parentMap[enroll[i]] = referral[i]
        }

        for (i in seller.indices) {
            var profit = amount[i] * 100
            var current = seller[i]

            while (current != "-" && profit > 0) {
                val parent = parentMap[current] ?: "-"
                val commission = profit / 10
                earnings[indexMap[current]!!] += profit - commission
                profit = commission
                current = parent
            }
        }

        return earnings
    }
}