fun main() {
    val t = readLine()!!.toInt()
    val max = 1_000_000
    val isPrime = BooleanArray(max + 1) { true }.apply {
        this[0] = false
        this[1] = false
        for (i in 2..Math.sqrt(max.toDouble()).toInt()) {
            if (this[i]) {
                for (j in i * i..max step i) {
                    this[j] = false
                }
            }
        }
    }

    repeat(t) {
        val n = readLine()!!.toInt()
        var count = 0
        for (i in 2..n / 2) {
            if (isPrime[i] && isPrime[n - i]) count++
        }
        println(count)
    }
}