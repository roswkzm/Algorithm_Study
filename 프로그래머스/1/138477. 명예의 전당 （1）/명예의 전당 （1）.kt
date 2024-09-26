import java.util.PriorityQueue

class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        val hallOfFame = PriorityQueue<Int>()  // 명예의 전당 (최소 힙)
        val result = mutableListOf<Int>()  // 발표 점수를 저장할 리스트

        for (i in score.indices) {
            hallOfFame.add(score[i])  // 현재 점수를 명예의 전당에 추가

            // 명예의 전당에 k개 이상의 점수가 있으면, 최하위 점수 제거
            if (hallOfFame.size > k) {
                hallOfFame.poll()  // 가장 작은 점수 제거
            }

            // 매일 명예의 전당에서 가장 작은 점수를 결과에 추가
            result.add(hallOfFame.peek()!!)
        }

        return result.toIntArray()
    }
}