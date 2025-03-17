fun main() {
    val n = readLine()!!.toInt()
    val list = MutableList(n) { readLine()!!.toInt() }
    var distance = mutableListOf<Int>()

    for (i in 1 until list.size) {
        distance.add(list[i] - list[i - 1])
    }

    var gcdValue = distance[0]
    for (gap in distance) {
        gcdValue = gcd(gcdValue, gap)
    }

    val result = distance.sumOf { it / gcdValue - 1 }
    println(result)
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}