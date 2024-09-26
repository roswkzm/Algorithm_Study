class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        // 바꾼 콜라 병수
        var changeCokeCount = 0
        var remainCount: Int = n

        // 콜라를 바꿀수 있을때까지 진행
        while (remainCount >= a) {
            val newCoke = (remainCount / a) * b  // 새로 얻은 콜라 병 수
            changeCokeCount += newCoke  // 바꾼 콜라 수 추가
            // 남은 병 = 이번에 바꾼 콜라의 빈 병 + 남은 빈 병
            remainCount = (remainCount % a) + newCoke
        }
        return changeCokeCount
    }
}