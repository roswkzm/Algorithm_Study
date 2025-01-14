class Solution {
    fun solution(relation: Array<Array<String>>): Int {
        
        var answer = 0
        var visited = BooleanArray(relation[0].size)

        fun checkCandidateKey(visited: BooleanArray): Boolean {
            var keys = relation.map { it.filterIndexed { index, _ -> visited[index] } }
            
            // isUnique
            for (key in keys) {
                if (keys.count { it == key } != 1) return false
            }

            // isMinimal
            if (visited.count { it } == 1) return true
            var count = 0
            for (i in 0 until keys[0].size) {
                var testKeys = keys.map { it.filterIndexed { index, _ -> index != i } }
                for (key in testKeys) {
                    if (testKeys.count { it == key } != 1) {
                        count++
                        break
                    }
                }
            }

            return count == visited.count { it }
        }

        fun dfs(visited: BooleanArray, now: Int) {
            if (checkCandidateKey(visited)) {
                answer++
                return
            }
            for (i in visited.indices) {
                if (!visited[i] && now <= i) {
                    visited[i] = true
                    dfs(visited, i)
                    visited[i] = false
                }
            }
        }

        dfs(visited, 0)
        return answer
    }
}