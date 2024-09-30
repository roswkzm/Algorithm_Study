class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        // 잃어버린 학생 중 여분 체육복도 없는 학생만 남긴다.
        val actualLost = lost.filter { it !in reserve }.toMutableList()
        // 여분 체육복이 있고 잃어버리지 않은 학생만 남긴다.
        val actualReserve = reserve.filter { it !in lost }.toMutableList()

        // 여분 체육복을 가진 학생들이 체육복을 빌려준다.
        for (reserveStudent in actualReserve.sorted()) {  // 여분 학생을 오름차순으로 정렬하여 처리
            when {
                reserveStudent - 1 in actualLost -> {
                    actualLost.remove(reserveStudent - 1)  // 앞번호 학생에게 빌려줌
                }
                reserveStudent + 1 in actualLost -> {
                    actualLost.remove(reserveStudent + 1)  // 뒷번호 학생에게 빌려줌
                }
            }
        }
        return n - actualLost.size
    }
}

