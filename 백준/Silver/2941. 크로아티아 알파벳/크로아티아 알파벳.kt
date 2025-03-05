fun main() {
    var word = readLine()!!
    val wordList = mutableListOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    wordList.forEach {
        word = word.replace(it, "*")
    }
    println(word.length)
}