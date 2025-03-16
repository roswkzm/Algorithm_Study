fun main() {
    val s = readLine()!!
    val substrings = mutableSetOf<String>()

    for (i in s.indices) {
        for (j in i + 1..s.length) {
            substrings.add(s.substring(i, j))
        }
    }

    println(substrings.size)
}