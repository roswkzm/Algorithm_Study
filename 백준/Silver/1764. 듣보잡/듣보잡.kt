fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val list = mutableSetOf<String>()
    val result = mutableListOf<String>()
    repeat(n) {
        list.add(readLine()!!)
    }

    repeat(m) {
        val name = readLine()!!
        if (name in list) {
            result.add(name)
        }
    }

    result.sort()
    println(result.size)
    result.forEach {
        println(it)
    }
}