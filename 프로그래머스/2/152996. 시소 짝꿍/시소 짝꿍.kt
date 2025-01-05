class Solution {
    fun solution(weights: IntArray): Long {
        val ratioPairs = listOf(2 to 3, 2 to 4, 3 to 4)
        val weightCount = mutableMapOf<Int, Long>()
        var pairCount = 0L

        // 몸무게 빈도수 계산
        weights.forEach { weight ->
            weightCount[weight] = weightCount.getOrDefault(weight, 0L) + 1
        }

        // 같은 몸무게끼리 짝 만들기
        weightCount.forEach { (weight, count) ->
            if (count > 1) {
                pairCount += count * (count - 1) / 2
            }
        }

        // 서로 다른 몸무게 짝 찾기
        for ((weight, count) in weightCount) {
            for ((num, den) in ratioPairs) {
                val otherWeight = weight * num / den
                if (weight * num % den == 0 && weightCount.containsKey(otherWeight)) {
                    pairCount += count * weightCount[otherWeight]!!
                }
            }
        }

        return pairCount // 중복 제거 필요 없음
    }
}