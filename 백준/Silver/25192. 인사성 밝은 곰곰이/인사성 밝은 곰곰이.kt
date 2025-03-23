fun main() {
    val n = readLine()!!.toInt()
    val memberSet = mutableSetOf<String>()
    var count = 0

    repeat(n) {
        val input = readLine()!!
        if (input == "ENTER") {
            count += memberSet.size
            memberSet.clear()
        } else {
            memberSet.add(input)
        }
    }
    
    count += memberSet.size
    
    println(count)
}