import kotlin.math.*

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val inOutTimeMap = mutableMapOf<String, Int>()
        val parkingTimeMap = mutableMapOf<String, Int>()

        for (record in records) {
            val (time, number, type) = record.split(" ")
            val minute = timeToMinute(time)

            if (type == "IN") {
                inOutTimeMap[number] = minute
            } else {
                val inTime = inOutTimeMap.remove(number)!!
                parkingTimeMap[number] = parkingTimeMap.getOrDefault(number, 0) + (minute - inTime)
            }
        }

        val closedTime = timeToMinute("23:59")
        for ((number, inTime) in inOutTimeMap){
            parkingTimeMap[number] = parkingTimeMap.getOrDefault(number, 0) + (closedTime - inTime)
        }

        return parkingTimeMap.toSortedMap().map{ calculationFee(it.value, fees) }.toIntArray()
    }
    
    private fun calculationFee(totalTime : Int, fees: IntArray): Int {
        val (defaultMinute, defaultFee, unitMinute, unitFee) = fees
        return if(totalTime <= defaultMinute) {
            defaultFee
        } else {
            defaultFee + ceil((totalTime - defaultMinute) / unitMinute.toDouble()).toInt() * unitFee
        }
    }

    private fun timeToMinute(s: String): Int {
        val (hour, minute) = s.split(":").map { it.toInt() }
        return hour * 60 + minute
    }
}