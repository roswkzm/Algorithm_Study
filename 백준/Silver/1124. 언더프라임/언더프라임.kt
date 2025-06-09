fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val max = b + 1
    val isPrime = BooleanArray(max) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2 until max) {
        if (isPrime[i]) {
            var j = i * 2
            while (j < max) {
                isPrime[j] = false
                j += i
            }
        }
    }

    fun countPrimeFactors(n: Int): Int {
        var num = n
        var count = 0
        var i = 2
        while (i * i <= num) {
            while (num % i == 0) {
                count++
                num /= i
            }
            i++
        }
        if (num > 1) count++
        return count
    }

    var result = 0
    for (i in a..b) {
        val factorCount = countPrimeFactors(i)
        if (factorCount > 0 && isPrime[factorCount]) {
            result++
        }
    }

    println(result)
}
