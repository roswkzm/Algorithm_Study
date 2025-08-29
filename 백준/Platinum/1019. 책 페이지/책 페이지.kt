import java.util.StringTokenizer

fun main() {
    val n = readLine()!!.toLong()
    val count = LongArray(10)

    fun addCount(num: Long, ten: Long) {
        var x = num
        while (x > 0) {
            count[(x % 10).toInt()] += ten
            x /= 10
        }
    }

    var start = 1L
    var end = n
    var ten = 1L

    while (start <= end) {
        while (start % 10 != 0L && start <= end) {
            addCount(start, ten)
            start++
        }
        if (start > end) break

        while (end % 10 != 9L && start <= end) {
            addCount(end, ten)
            end--
        }

        val cnt = (end / 10 - start / 10 + 1)
        for (i in 0..9) {
            count[i] += cnt * ten
        }

        start /= 10
        end /= 10
        ten *= 10
    }

    val sb = StringBuilder()
    for (i in 0..9) {
        sb.append(count[i]).append(' ')
    }
    println(sb.toString().trim())
}
