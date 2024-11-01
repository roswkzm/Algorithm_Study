class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        val gcdA = arrayA.reduce { acc, i -> gcd(acc, i) }
        val gcdB = arrayB.reduce { acc, i -> gcd(acc, i) }

        val isGcdAValid = arrayB.all { it % gcdA != 0 }
        val isGcdBValid = arrayA.all { it % gcdB != 0 }

        return when {
            isGcdAValid && isGcdBValid -> maxOf(gcdA, gcdB)
            isGcdAValid -> gcdA
            isGcdBValid -> gcdB
            else -> 0
        }
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}