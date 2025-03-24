fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val sb = StringBuilder()

    fun backtrack(currList: MutableList<Int>) {
        if (currList.size == m) {
            sb.appendLine(currList.joinToString(" "))
            return
        }
        for (i in 1..n) {
            currList.add(i)
            backtrack(currList)
            currList.removeAt(currList.size - 1)
        }
    }

    backtrack(mutableListOf())
    print(sb)
}