fun main() {
    val input = readLine()!!
    val parts = input.split("-")

    val firstSum = parts[0].split("+").sumOf { it.toInt() }

    val restSum = parts.drop(1).sumOf { part ->
        part.split("+").sumOf { it.toInt() }
    }

    println(firstSum - restSum)
}
