fun main() {
    while (true) {
        val code = readLine()!!
        if (code != "END") {
            println(code.reversed())
        } else {
            break
        }
    }
}
