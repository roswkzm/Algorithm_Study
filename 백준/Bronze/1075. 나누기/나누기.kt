fun main() {
    val n = readLine()!!.toInt()
    val f = readLine()!!.toInt()

    val newN = (n / 100) * 100
    for (i in 0 until 100) {
        if ((newN + i) % f == 0) {
            println(i.toString().padStart(2, '0'))
            break
        }
    }
}