class Solution {
    fun solution(weights: IntArray): Long {
        val ratioPairs = listOf(2 to 3, 2 to 4, 3 to 4)
        val weightCount = mutableMapOf<Int, Long>()
        var pairCount = 0L

        weights.forEach { weight ->
            weightCount[weight] = weightCount.getOrDefault(weight, 0L) + 1
        }

        weightCount.forEach { (weight, count) ->
            if (count > 1) {
                pairCount += count * (count - 1) / 2
            }
        }

        for ((weight, count) in weightCount) {
            for ((num, den) in ratioPairs) {
                val otherWeight = weight * num / den
                if (weight * num % den == 0 && weightCount.containsKey(otherWeight)) {
                    pairCount += count * weightCount[otherWeight]!!
                }
            }
        }

        return pairCount
    }
}