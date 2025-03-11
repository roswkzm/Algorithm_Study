fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val (c, d) = readLine()!!.split(" ").map { it.toInt() }

    val numerator = a * d + b * c
    val denominator = b * d
    val gcdValue = gcd(numerator, denominator)

    println("${numerator / gcdValue} ${denominator / gcdValue}")
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}