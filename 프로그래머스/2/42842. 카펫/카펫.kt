import kotlin.math.sqrt

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val answer = mutableListOf<Int>()
        val totalCount = brown + yellow

        // 카펫은 직사각형이기 때문에 타일의 총 갯수의 약수로 이루어져 있음
        // i가 가로라고 생각하고 있고 카펫의 가로가 더 크니까 역순으로 진행
        for (height in 3..sqrt(totalCount.toDouble()).toInt()) {
            if (totalCount % height == 0) {
                val width = totalCount / height

                if ((width - 2) * (height - 2) == yellow) {
                    answer.add(width)
                    answer.add(height)
                }
            }
        }

        return answer.toIntArray()
    }
}