fun main() {
    val chessPiece = mutableListOf(1, 1, 2, 2, 2, 8)
    val myPiece = readLine()!!.split(" ").map { it.toInt() }
    println(chessPiece.mapIndexed { index, i -> i - myPiece[index] }.joinToString(" "))
}