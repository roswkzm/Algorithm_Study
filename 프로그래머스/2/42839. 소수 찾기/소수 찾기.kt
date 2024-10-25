import kotlin.math.sqrt

class Solution {
    fun solution(numbers: String): Int {
        val makeWordList = mutableSetOf<String>()

        fun backtrack(word: String, userIndex: MutableList<Int>) {
            if (word.isNotEmpty() && word.toInt() > 1 && word.first() != '0') {
                if (isPrime(word.toInt())) {
                    makeWordList.add(word)
                }
            }
            for (i in numbers.indices) {
                if (i !in userIndex) {
                    userIndex.add(i)
                    backtrack(word + numbers[i], userIndex)
                    userIndex.removeAt(userIndex.size - 1)
                }
            }
        }

        backtrack("", mutableListOf())
        return makeWordList.count()
    }

    private fun isPrime(num: Int): Boolean {
        if (num < 2) return false

        for (i in 2..sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) return false
        }
        return true
    }
}