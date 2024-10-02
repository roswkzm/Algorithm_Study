class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val answer = IntArray(2)

        // 알아볼수 없는 숫자 개수
        val forgotNumberCount = lottos.count { it == 0 }
        // 당첨 숫자 개수
        val correctNumberCount = win_nums.count { lottos.contains(it) }

        // 최대 당첨 가능 개수 -> (당첨 숫자 개수 + 알아볼 수 없는 숫자), 최소 당첨 가능 개수 -> (당첨숫자 개수)
        answer[0] = lottoLank(correctNumberCount + forgotNumberCount)
        answer[1] = lottoLank(correctNumberCount)

        return answer
    }

    private fun lottoLank(correctCount: Int): Int {
        return when (correctCount) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }
    }
}