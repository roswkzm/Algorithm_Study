import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val myDeck = (1..n).toMutableList()
    val deleteDeck = mutableListOf<Int>()

    while (myDeck.size != 1) {
        deleteDeck.add(myDeck.removeFirst())
        myDeck.add(myDeck.removeFirst())
    }
    println((deleteDeck + myDeck).joinToString(" "))
}
