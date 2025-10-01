fun main() {
    val n = readln().toInt()
    val full = (1 shl n) - 1
    var count = 0

    fun dfs(cols: Int, diag1: Int, diag2: Int) {
        if (cols == full) {
            count++
            return
        }
        var avail = full and (cols or diag1 or diag2).inv()
        while (avail != 0) {
            val bit = avail and -avail
            avail -= bit
            dfs(cols or bit, (diag1 or bit) shl 1 and full, (diag2 or bit) shr 1)
        }
    }

    dfs(0, 0, 0)
    println(count)
}
