fun main() {
    val s = readLine()!!
    val result = IntArray(26) { -1 }
    s.forEachIndexed { index, c ->
        val alphabetIndex = c.code % 97
        if (result[alphabetIndex] == -1) {
            result[alphabetIndex] = index
        }
    }
    println(result.joinToString(" "))
}
