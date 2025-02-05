class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = mutableSetOf<Int>()
        
        queue.add(0 to x)
        visited.add(x)
        
        while(queue.isNotEmpty()) {
            
            val (step, value) = queue.removeFirst()
            val direction = listOf(value + n, value * 2, value * 3)
            
            if(value == y) {
                return step
            }
            
            for(direct in direction) {
                if(direct <= y && direct !in visited) {
                    queue.add(step + 1 to direct)
                    visited.add(direct)
                }
            }
        }
        
        return -1
    }
}