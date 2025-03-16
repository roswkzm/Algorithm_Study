fun main() {
    val n = readLine()!!.toInt()
    val people = mutableSetOf<String>()

    repeat(n) {
        val (name, commend) = readLine()!!.split(" ")
        if (commend == "enter") {
            people.add(name)
        } else {
            people.remove(name)
        }
    }
    println(people.sortedDescending().joinToString("\n"))
}