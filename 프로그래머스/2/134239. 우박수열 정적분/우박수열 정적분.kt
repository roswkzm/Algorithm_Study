class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        // 1. 우박수열 생성
        val hailstoneSequence = mutableListOf<Double>()
        var current = k.toDouble()
        hailstoneSequence.add(current)

        while (current > 1) {
            current = if (current % 2 == 0.0) current / 2 else current * 3 + 1
            hailstoneSequence.add(current)
        }

        println(hailstoneSequence)

        // 2. 각 구간의 면적 계산
        val areaSums = mutableListOf<Double>()
        for (i in 0 until hailstoneSequence.size - 1) {
            val left = hailstoneSequence[i]
            val right = hailstoneSequence[i + 1]
            areaSums.add((left + right) / 2) // 사다리꼴 면적
        }

        // 누적 면적 합 계산
        val cumulativeAreas = mutableListOf(0.0)
        for (area in areaSums) {
            cumulativeAreas.add(cumulativeAreas.last() + area)
        }

        // 3. 주어진 범위의 정적분 값 계산
        return ranges.map { (a, b) ->
            val end = hailstoneSequence.size - 1 + b
            if (a > end || end < 0) {
                // 유효하지 않은 범위
                -1.0
            } else {
                // 누적 면적 합을 이용해 구간 넓이 계산
                cumulativeAreas[end] - cumulativeAreas[a]
            }
        }.toDoubleArray()
    }
}
