class Solution {
    fun solution(word: String): Int {
        val alphabet = listOf("A", "E", "I", "O", "U")
        val makeWordList = mutableListOf<String>()

        fun backtrack(s : String) {
            if(s.length > 5) return

            if(s.isNotEmpty()) makeWordList.add(s)

            for(a in alphabet) {
                backtrack(s + a)
            }
        }

        backtrack("")

        println(makeWordList)

        return makeWordList.indexOf(word) + 1
    }
}