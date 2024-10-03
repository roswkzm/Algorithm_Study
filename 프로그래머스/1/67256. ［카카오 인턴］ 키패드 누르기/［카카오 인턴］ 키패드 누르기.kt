import kotlin.math.abs

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        val numberPad = arrayOf(
            arrayOf("1", "4", "7", "*"),
            arrayOf("2", "5", "8", "0"),
            arrayOf("3", "6", "9", "#")
        )
        var leftPosition = arrayOf(0, 3)
        var rightPosition = arrayOf(2, 3)
        val isLeftHands = hand == "left"


        for (number in numbers) {

            when {
                (number % 3 == 1) -> {
                    answer += "L"
                    leftPosition = arrayOf(0, numberPad[0].indexOf(number.toString()))
                }

                (number % 3 == 2) || (number == 0) -> {
                    val numberPosition = arrayOf(1, numberPad[1].indexOf(number.toString()))
                    val leftDistance =
                        numberPosition.zip(leftPosition) { a, b -> abs(a - b) }.sum()
                    val rightDistance =
                        numberPosition.zip(rightPosition) { a, b -> abs(a - b) }.sum()

                    // 왼손이 더 멀경우(오른손이 더 가까울 경우)
                    if (leftDistance > rightDistance) {
                        answer += "R"
                        rightPosition = numberPosition
                    } else if (leftDistance == rightDistance) {  // 두손다 동일하게 떨어진 경우
                        if (isLeftHands) {
                            answer += "L"
                            leftPosition = numberPosition
                        } else {
                            answer += "R"
                            rightPosition = numberPosition
                        }
                    } else {    // 오른손이 더 멀경우(왼손이 더 가까울 경우)
                        answer += "L"
                        leftPosition = numberPosition
                    }
                }

                (number % 3 == 0) -> {
                    answer += "R"
                    rightPosition = arrayOf(2, numberPad[2].indexOf(number.toString()))
                }
            }
        }

        return answer
    }
}