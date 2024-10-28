import kotlin.math.sqrt

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer = 0
        val number = n.toString(k)
        number.split("0").forEach {
            if (it.isNotEmpty() && isPrime(it.toDouble())) answer++
        }

        return answer
    }

    private fun isPrime(n: Double): Boolean {
        if (n <= 1) return false
        return (2..sqrt(n).toInt()).none { (n % it).toInt() == 0 }
    }
}