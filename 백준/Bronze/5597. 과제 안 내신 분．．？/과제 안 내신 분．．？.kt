fun main() {
    val students = BooleanArray(31) { false }
    
    repeat(28) {
        val submitted = readLine()!!.toInt()
        students[submitted] = true
    }

    for (i in 1..30) {
        if (!students[i]) println(i)
    }
}