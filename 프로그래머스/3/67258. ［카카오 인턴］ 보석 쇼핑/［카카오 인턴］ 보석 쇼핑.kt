class Solution {
    fun solution(gems: Array<String>): IntArray {
        // 모든 보석의 종류를 담은 Set
        val gemTypes = gems.toSet()
        val gemCount = gemTypes.size

        // 보석 구간 내 보석 종류와 개수를 저장할 Map
        val gemMap = mutableMapOf<String, Int>()
        var start = 0
        var end = 0
        var minLength = Int.MAX_VALUE
        var result = intArrayOf(0, 0)

        while (end < gems.size) {
            // 현재 보석을 Map에 추가
            gemMap[gems[end]] = gemMap.getOrDefault(gems[end], 0) + 1
            end++

            // 모든 종류의 보석이 포함된 경우
            while (gemMap.size == gemCount) {
                // 현재 구간의 길이를 계산
                if (end - start < minLength) {
                    minLength = end - start
                    result = intArrayOf(start + 1, end)
                }

                // 구간을 축소
                val startGem = gems[start]
                gemMap[startGem] = gemMap[startGem]!! - 1
                if (gemMap[startGem] == 0) {
                    gemMap.remove(startGem)
                }
                start++
            }
        }

        return result
    }
}
