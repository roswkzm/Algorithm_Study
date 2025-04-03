fun main() {
    val s = readLine()!!
    val q = readLine()!!.toInt()

    repeat(q) {
        val (a, l, r) = readLine()!!.split(" ")
        val result = s.slice(l.toInt()..r.toInt()).count { it.toString() == a }
        println(result)
    }
}