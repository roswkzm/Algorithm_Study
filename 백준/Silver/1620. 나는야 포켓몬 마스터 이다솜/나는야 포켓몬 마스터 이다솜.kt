fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val nameToIndex = mutableMapOf<String, Int>()
    val indexToName = mutableListOf<String>()

    repeat(n) {
        val name = readLine()!!
        nameToIndex[name] = it + 1
        indexToName.add(name)
    }

    repeat(m) {
        val quest = readLine()!!
        if (quest.first().isDigit()) {
            println(indexToName.get(quest.toInt() - 1))
        } else {
            println(nameToIndex.getValue(quest))
        }
    }
}