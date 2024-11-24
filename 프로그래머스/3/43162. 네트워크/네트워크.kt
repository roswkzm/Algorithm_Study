class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val visited = BooleanArray(n)

        fun dfs(node: Int) {
            visited[node] = true
            for (j in computers[node].indices) {
                if (!visited[j] && computers[node][j] == 1) {
                    dfs(j)
                }
            }
        }

        for (i in computers.indices) {
            if (!visited[i]) {
                answer++
                dfs(i)
            }
        }

        return answer
    }
}