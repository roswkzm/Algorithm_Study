fun main() {
    val n = readLine()!!.toInt()
    val books = readLine()!!.split(" ").map { it.toInt() }

    val lis = mutableListOf<Int>()

    for (book in books) {
        val idx = lis.binarySearch(book)
        if (idx < 0) {
            val insertPos = -(idx + 1)
            if (insertPos == lis.size) {
                lis.add(book)
            } else {
                lis[insertPos] = book
            }
        }
    }

    println(n - lis.size)
}
