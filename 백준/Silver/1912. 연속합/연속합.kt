fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map { it.toInt() }

    val dp = IntArray(n)
    dp[0] = nums[0]
    var maxSum = dp[0]
    
    for (i in 1 until n) {
        dp[i] = maxOf(nums[i], dp[i - 1] + nums[i])
        maxSum = maxOf(maxSum, dp[i])
    }
    println(maxSum)
}