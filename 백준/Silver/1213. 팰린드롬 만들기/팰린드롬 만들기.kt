fun main() {
    val name = readln()
    val count = IntArray(26)
    for (c in name) count[c - 'A']++

    var oddCount = 0
    var oddChar = -1
    for (i in 0 until 26) {
        if (count[i] % 2 == 1) {
            oddCount++
            oddChar = i
        }
    }

    if (oddCount > 1) {
        println("I'm Sorry Hansoo")
        return
    }

    val half = StringBuilder()
    for (i in 0 until 26) {
        repeat(count[i] / 2) { half.append(('A' + i)) }
    }

    val result = StringBuilder()
    result.append(half)
    if (oddChar != -1) result.append(('A' + oddChar))
    result.append(half.reversed())

    println(result.toString())
}
