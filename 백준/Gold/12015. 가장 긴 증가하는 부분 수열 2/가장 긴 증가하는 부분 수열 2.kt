fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val lis = mutableListOf<Int>()

    for (x in arr) {
        var l = 0
        var r = lis.size
        while (l < r) {
            val mid = (l + r) / 2
            if (lis[mid] < x) l = mid + 1 else r = mid
        }
        if (l == lis.size) lis.add(x) else lis[l] = x
    }
    println(lis.size)
}
