class Solution {
    fun solution(maps: Array<String>): Int {
        var startIndex = Pair(0, 0)
        var endIndex = Pair(0, 0)
        var leverIndex = Pair(0, 0)
        val directions = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        
        maps.forEachIndexed{ rowIndex, s ->
            s.forEachIndexed{ colIndex, c -> 
                when(c) {
                    'S' -> startIndex = rowIndex to colIndex
                    'E' -> endIndex = rowIndex to colIndex
                    'L' -> leverIndex = rowIndex to colIndex
                }
            }
        }
        
        fun bfs(origin: Pair<Int, Int>, destination : Pair<Int, Int>) : Int? {
            val visited = Array(maps.size) { BooleanArray(maps[0].length) }
            val queue = ArrayDeque<Triple<Int, Int, Int>>()
            
            queue.add(Triple(origin.first, origin.second, 0))
            visited[origin.first][origin.second] = true
            
            while(queue.isNotEmpty()) {
                val (row, col, time) = queue.removeFirst()
                if(row to col == destination) {
                    return time
                }
                
                for((dr, dc) in directions) {
                    val nextRow = row + dr
                    val nextCol = col + dc
                    if(nextRow in maps.indices && nextCol in maps[0].indices && !visited[nextRow][nextCol] && maps[nextRow][nextCol] != 'X') {
                        queue.add(Triple(nextRow, nextCol, time + 1))
                        visited[nextRow][nextCol] = true
                    }
                }
            }
            return null
        }
        
        val startToLever = bfs(startIndex, leverIndex) ?: return -1
        val leverToEnd = bfs(leverIndex, endIndex) ?: return -1
        
        println(startToLever)
        println(leverToEnd)
        
        return startToLever + leverToEnd
    }
}