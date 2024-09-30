import kotlin.math.sqrt

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        val knightPowerList = IntArray(number)
        // 모든 기사들에 대하여
        for (i in 1..number){
            var knightPower = 0   // 기사에 대한 약수개수를 담는 변수
            // 기사단원번호의 약수 개수 구하기
            for (j in 1..sqrt(i.toDouble()).toInt()){
                if (i % j == 0){
                    knightPower += 2
                }
                if (j * j == i) {
                    knightPower--
                }
            }

            // 제한수치(Limit)을 넘는애들은 공격력을 power로 써야한다.
            if (knightPower > limit){
                knightPower = power
            }
            knightPowerList[i-1] = knightPower
        }
        return knightPowerList.sum()
    }
}