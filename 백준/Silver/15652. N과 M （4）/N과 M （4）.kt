fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val sb = StringBuilder()

    fun backtrack(start: Int, currList: MutableList<Int>) {
        if (currList.size == m) {
            sb.appendLine(currList.joinToString(" "))
            return
        }
        for (i in start..n) {
            currList.add(i)
            backtrack(i, currList)
            currList.removeAt(currList.size - 1)
        }
    }

    backtrack(1, mutableListOf())
    print(sb)
}
