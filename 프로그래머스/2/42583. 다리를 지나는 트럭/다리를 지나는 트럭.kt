class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        val truckList = truck_weights.toMutableList()

        queue.add(truckList.removeFirst() to 0)

        while (queue.isNotEmpty()) {
            // 시간초 증가
            answer++
            // 현재 다리위에 있는 트럭들 무게
            var currentBridgeWeight = queue.sumOf { it.first }
            // 다리위의 트럭들 1칸씩 전진
            queue.forEachIndexed { index, pair ->
                queue[index] = pair.first to (pair.second + 1)
            }
            // 맨 앞의 트럭이 bridge_length랑 똑같다면 다 건넌거다.
            if (queue.first().second > bridge_length) {
                queue.removeFirst()
                currentBridgeWeight = queue.sumOf { it.first }
            }
            // 다음트럭이 건널 수 있다면 건너라
            if (truckList.isNotEmpty() && currentBridgeWeight + truckList.first() <= weight) {
                queue.add(truckList.removeFirst() to 1)
            }
        }

        return answer
    }
}