class Solution {
    fun solution(word: String): Int {
        val alphabet = listOf("A", "E", "I", "O", "U")
        val wordMakeList = mutableListOf<String>()

        fun backtrack(current: String) {
            if (current.length > alphabet.size) {
                return
            }
            if (current.isNotEmpty()) {
                wordMakeList.add(current)
            }

            for (c in alphabet) {
                backtrack(current + c)
            }
        }

        backtrack("")
        return wordMakeList.indexOf(word) + 1
    }
}