fun main() {
    val (A, B) = readLine()!!.split(" ")

    var minDiff = Int.MAX_VALUE

    for (i in 0..(B.length - A.length)) {
        var diff = 0
        for (j in A.indices) {
            if (A[j] != B[i + j]) diff++
        }
        minDiff = minOf(minDiff, diff)
    }

    println(minDiff)
}
