fun main() {
    val n = readLine()!!.toInt()
    var result = 0
    repeat(n) {
        val word = readLine()!!
        if (isGrouping(word)) result++
    }
    println(result)
}

fun isGrouping(word: String): Boolean {
    val visited = mutableSetOf<Char>()
    var prevChar: Char? = null

    for (char in word) {
        if (char != prevChar) {
            if (char in visited) return false
            visited.add(char)
        }
        prevChar = char
    }
    return true
}