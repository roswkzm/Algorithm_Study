import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dq = ArrayDeque<Int>()
    val sb = StringBuilder()

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        when (st.nextToken().toInt()) {
            1 -> dq.addFirst(st.nextToken().toInt())
            2 -> dq.addLast(st.nextToken().toInt())
            3 -> sb.append(if (dq.isEmpty()) -1 else dq.removeFirst()).append('\n')
            4 -> sb.append(if (dq.isEmpty()) -1 else dq.removeLast()).append('\n')
            5 -> sb.append(dq.size).append('\n')
            6 -> sb.append(if (dq.isEmpty()) 1 else 0).append('\n')
            7 -> sb.append(if (dq.isEmpty()) -1 else dq.first).append('\n')
            8 -> sb.append(if (dq.isEmpty()) -1 else dq.last).append('\n')
        }
    }
    print(sb)
}
