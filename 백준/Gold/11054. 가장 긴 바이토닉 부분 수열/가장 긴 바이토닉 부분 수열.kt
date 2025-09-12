import java.util.StringTokenizer

fun main() {
    val n = readln().trim().toInt()
    val st = StringTokenizer(readln())
    val a = IntArray(n) { st.nextToken().toInt() }

    val lis = IntArray(n) { 1 }
    for (i in 0 until n) {
        for (j in 0 until i) {
            if (a[j] < a[i]) lis[i] = maxOf(lis[i], lis[j] + 1)
        }
    }

    val lds = IntArray(n) { 1 }
    for (i in n - 1 downTo 0) {
        for (j in n - 1 downTo i + 1) {
            if (a[j] < a[i]) lds[i] = maxOf(lds[i], lds[j] + 1)
        }
    }

    var ans = 0
    for (i in 0 until n) ans = maxOf(ans, lis[i] + lds[i] - 1)
    println(ans)
}
