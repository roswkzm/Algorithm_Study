fun main() {
    val (n, s) = readLine()!!.split(" ").map { it.toInt() }
    val nums = readLine()!!.split(" ").map { it.toInt() } // ❌ sorted() 제거

    var sum = 0
    var left = 0
    var minLen = Int.MAX_VALUE

    for (right in 0 until n) {
        sum += nums[right]
        
        while (sum >= s) {
            minLen = minOf(minLen, right - left + 1)
            sum -= nums[left++]
        }
    }

    println(if (minLen == Int.MAX_VALUE) 0 else minLen)
}
