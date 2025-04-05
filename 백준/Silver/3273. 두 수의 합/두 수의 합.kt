fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val x = readLine()!!.toInt()

    var left = 0
    var right = n - 1
    var count = 0

    while (left < right) {
        val sum = nums[left] + nums[right]
        when {
            sum == x -> {
                count++
                left++
                right--
            }
            sum < x -> {
                left++
            }
            else -> right--
        }
    }

    println(count)
}