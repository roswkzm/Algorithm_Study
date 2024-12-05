class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var distance = 0L
        var remainingDeliveries = deliveries.copyOf()
        var remainingPickups = pickups.copyOf()

        var i = n - 1
        while (i >= 0) {
            // 현재 처리할 구간
            while (i >= 0 && remainingDeliveries[i] == 0 && remainingPickups[i] == 0) {
                i--
            }
            if (i < 0) break

            // 이동 거리 (가장 멀리 있는 집)
            distance += (i + 1) * 2

            // 트럭의 배달 및 수거 작업 수행
            var currentCap = cap
            var j = i
            while (j >= 0 && currentCap > 0) {
                // 배달 작업
                val deliverable = minOf(currentCap, remainingDeliveries[j])
                remainingDeliveries[j] -= deliverable
                currentCap -= deliverable

                j--
            }

            currentCap = cap
            j = i
            while (j >= 0 && currentCap > 0) {
                val pickupable = minOf(currentCap, remainingPickups[j])
                remainingPickups[j] -= pickupable
                currentCap -= pickupable

                j--
            }
        }

        return distance
    }
}