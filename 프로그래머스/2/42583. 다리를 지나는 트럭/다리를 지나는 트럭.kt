class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        val truckList = truck_weights.toMutableList()
        
        queue.add(truckList.removeFirst() to 0)
        
        while(queue.isNotEmpty()) {
            answer++
            queue.forEachIndexed{index, pair -> 
                queue[index] = pair.first to pair.second + 1
            }
            
            if(queue.first().second > bridge_length){
                queue.removeFirst()
            }
            
            val totalWeight = queue.sumOf{ it.first }
            
            if(truckList.isNotEmpty() && totalWeight + truckList.first() <= weight && queue.size < bridge_length){
                queue.add(truckList.removeFirst() to 1)
            }
        }
        
        return answer
    }
}