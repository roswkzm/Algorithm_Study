class Solution {
    fun solution(n: Int): Array<IntArray> {
        val answer = mutableListOf<IntArray>()

        fun hanoi(n: Int, start: Int, target: Int, sub: Int) {
            if (n == 1) {
                answer.add(intArrayOf(start, target))
                return
            }

            hanoi(n - 1, start, sub, target)
            answer.add(intArrayOf(start, target))
            hanoi(n - 1, sub, target, start)
        }

        hanoi(n, 1, 3, 2)

        return answer.toTypedArray()
    }
}