fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val nums = readLine()!!.split(" ").map { it.toInt() }
    val prefix = IntArray(n + 1)

    for (i in 1..n) {
        prefix[i] = prefix[i - 1] + nums[i - 1]
    }

    repeat(m) {
        val (i, j) = readLine()!!.split(" ").map { it.toInt() }
        println(prefix[j] - prefix[i - 1])
    }
}