var count = 0

fun recursion(s: String, l: Int, r: Int): Int {
    count++
    return when {
        l >= r -> 1
        s[l] != s[r] -> 0
        else -> recursion(s, l + 1, r - 1)
    }
}

fun isPalindrome(s: String): Int {
    return recursion(s, 0, s.length - 1)
}

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val s = readLine()!!
        count = 0
        val result = isPalindrome(s)
        println("$result $count")
    }
}
