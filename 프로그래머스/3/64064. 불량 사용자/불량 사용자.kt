class Solution {
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val bannedMatches = banned_id.map { banned ->
            val regex = banned.replace("*", ".").toRegex()
            user_id.filter { user -> user.matches(regex) }
        }
        val resultSet = mutableSetOf<Set<String>>()

        fun dfs(index: Int, currentSet: MutableSet<String>) {
            if (index == bannedMatches.size) {
                resultSet.add(currentSet.toSet())
                return
            }

            for (user in bannedMatches[index]) {
                if (!currentSet.contains(user)) {
                    currentSet.add(user)
                    dfs(index + 1, currentSet)
                    currentSet.remove(user)
                }
            }
        }
        
        dfs(0, mutableSetOf())
        
        return resultSet.size
    }
}