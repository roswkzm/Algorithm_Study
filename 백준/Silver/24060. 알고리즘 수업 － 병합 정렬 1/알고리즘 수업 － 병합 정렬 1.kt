import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var cnt = 0
var result = -1
var K = 0
lateinit var A: IntArray
lateinit var tmp: IntArray

fun merge(p: Int, q: Int, r: Int) {
    var i = p
    var j = q + 1
    var t = p

    while (i <= q && j <= r) {
        if (A[i] <= A[j]) {
            tmp[t] = A[i]
            i++
        } else {
            tmp[t] = A[j]
            j++
        }
        t++
    }

    while (i <= q) {
        tmp[t] = A[i]
        i++
        t++
    }

    while (j <= r) {
        tmp[t] = A[j]
        j++
        t++
    }

    for (i in p..r) {
        A[i] = tmp[i]
        cnt++
        if (cnt == K) {
            result = A[i]
        }
    }
}

fun mergeSort(p: Int, r: Int) {
    if (p < r) {
        val q = (p + r) / 2
        mergeSort(p, q)
        mergeSort(q + 1, r)
        merge(p, q, r)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    K = st.nextToken().toInt()
    A = IntArray(N)
    tmp = IntArray(N)

    val st2 = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        A[i] = st2.nextToken().toInt()
    }

    mergeSort(0, N - 1)
    println(result)
}
