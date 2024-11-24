class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {

        if (!words.contains(target)) {
            return 0
        }

        val visited = BooleanArray(words.size)

        fun isOneCharDifferent(word1: String, word2: String): Boolean {
            var diff = 0
            for (i in word1.indices) {
                if (word1[i] != word2[i]) diff++
                if (diff > 1) return false
            }
            return diff == 1
        }

        fun bfs(word: String): Int {
            val queue = ArrayDeque<Pair<String, Int>>()
            queue.add(word to 0)

            while (queue.isNotEmpty()) {
                val (currWord, step) = queue.removeFirst()

                if (currWord == target) {
                    return step
                }

                for ((index, nextWord) in words.withIndex()) {
                    if (isOneCharDifferent(currWord, nextWord) && !visited[index]) {
                        queue.add(nextWord to step + 1)
                        visited[index] = true
                    }
                }
            }
            return 0
        }
        return bfs(begin)
    }
}