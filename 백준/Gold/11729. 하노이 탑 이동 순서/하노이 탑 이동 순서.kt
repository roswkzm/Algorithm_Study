fun hanoi(n: Int, from: Int, to: Int, via: Int, result: StringBuilder) {
    if (n == 1) {
        result.append("$from $to\n")
        return
    }
    hanoi(n - 1, from, via, to, result)
    result.append("$from $to\n")
    hanoi(n - 1, via, to, from, result)
}

fun main() {
    val n = readLine()!!.toInt()
    val result = StringBuilder()

    result.append("${(1 shl n) - 1}\n")
    hanoi(n, 1, 3, 2, result)

    print(result)
}
