fun main() {
    var (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val students = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()
    println(students[k - 1])
}