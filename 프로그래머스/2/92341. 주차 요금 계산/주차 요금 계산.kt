import kotlin.math.ceil

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val parkingTimeMap = mutableMapOf<String, Int>()
        val inTimeMap = mutableMapOf<String, Int>()

        // 시각을 분으로 변환하는 함수
        fun timeToMinutes(time: String): Int {
            val (hour, minute) = time.split(":").map { it.toInt() }
            return hour * 60 + minute
        }

        // 주차 요금을 계산하는 함수
        fun calculateFee(totalTime: Int, fees: IntArray): Int {
            val (baseTime, baseFee, unitTime, unitFee) = fees
            return if (totalTime <= baseTime) {
                baseFee
            } else {
                baseFee + ceil((totalTime - baseTime) / unitTime.toDouble()).toInt() * unitFee
            }
        }

        // 기록을 하나씩 처리
        for (record in records) {
            val (time, carNumber, action) = record.split(" ")
            val minutes = timeToMinutes(time)

            if (action == "IN") {
                inTimeMap[carNumber] = minutes
            } else if (action == "OUT") {
                val inTime = inTimeMap.remove(carNumber)!!
                parkingTimeMap[carNumber] =
                    parkingTimeMap.getOrDefault(carNumber, 0) + (minutes - inTime)
            }
        }

        // 입차된 채 출차 기록이 없는 차량을 23:59에 출차한 것으로 간주
        val closingTime = timeToMinutes("23:59")
        for ((carNumber, inTime) in inTimeMap) {
            parkingTimeMap[carNumber] =
                parkingTimeMap.getOrDefault(carNumber, 0) + (closingTime - inTime)
        }

        // 차량 번호 순으로 정렬하고 요금을 계산하여 결과 배열로 반환
        return parkingTimeMap.keys.sorted().map { carNumber ->
            calculateFee(parkingTimeMap[carNumber]!!, fees)
        }.toIntArray()
    }
}