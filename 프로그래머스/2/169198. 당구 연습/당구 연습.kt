import kotlin.math.*

class Solution {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        val answer = IntArray(balls.size) { 0 }

        fun distance(x1: Int, y1: Int, x2: Int, y2: Int) =
            (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)

        fun leftCushion(ball: Pair<Int, Int>) =
            distance(ball.first, ball.second, startX*-1, startY)

        fun rightCushion(ball: Pair<Int, Int>) =
            distance(ball.first, ball.second, m*2-startX, startY)

        fun topCushion(ball: Pair<Int, Int>) =
            distance(ball.first, ball.second, startX, n*2-startY)

        fun bottomCushion(ball: Pair<Int, Int>) =
            distance(ball.first, ball.second, startX, startY*-1)

        fun checkShort(ball: Pair<Int, Int>): Int {
            return if (startX == ball.first) {
                if (startY < ball.second) {
                    min(bottomCushion(ball), min(leftCushion(ball), rightCushion(ball)))
                } else {
                    min(topCushion(ball), min(leftCushion(ball), rightCushion(ball)))
                }
            } else if (startY == ball.second) {
                if (startX < ball.first) {
                    min(leftCushion(ball), min(topCushion(ball), bottomCushion(ball)))
                } else {
                    min(rightCushion(ball), min(topCushion(ball), bottomCushion(ball)))
                }
            } else {
                min(min(leftCushion(ball), rightCushion(ball)), min(topCushion(ball), bottomCushion(ball)))
            }
        }

        balls.forEachIndexed { index, ints ->
            answer[index] = checkShort(Pair(ints[0], ints[1]))
        }

        return answer
    }
}