fun main() {
    val n = readLine()!!.toInt()
    fun fibo(n: Int): Int {
        if (n <= 1) return n
        return fibo(n - 1) + fibo(n - 2)
    }

    println(fibo(n))
}