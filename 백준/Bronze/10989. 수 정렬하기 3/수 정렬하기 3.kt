import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    val count = IntArray(10001)

    repeat(n) {
        val num = br.readLine().toInt()
        count[num]++
    }

    for (i in 1..10000) {
        repeat(count[i]) { bw.write("$i\n") }
    }

    bw.flush()
    bw.close()
}
