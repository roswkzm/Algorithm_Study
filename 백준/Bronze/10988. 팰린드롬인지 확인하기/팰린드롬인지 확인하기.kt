fun main() {
    val word = readLine()!!
    var isFelindrome = true
    for (i in 0 until word.length / 2) {
        val reverseIndex = word.length - 1 - i
        if (word[i] != word[reverseIndex]) isFelindrome = false
    }
    if (isFelindrome) {
        println("1")
    } else {
        println("0")
    }
}