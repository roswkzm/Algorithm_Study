import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val box = Array(N) { IntArray(M) }
    repeat(N) { i ->
        val st2 = StringTokenizer(br.readLine())
        repeat(M) { j ->
            box[i][j] = st2.nextToken().toInt()
        }
    }

    // 한 박스를 조커로 선택하거나(0..N-1), 조커를 아예 두지 않기(-1)도 고려
    var answer = Int.MAX_VALUE
    for (joker in -1 until N) {
        val used = BooleanArray(M) // 이미 대표 박스로 확정된 색
        var moves = 0

        for (i in 0 until N) {
            if (i == joker) continue

            // 이 박스에 들어있는 색의 개수와 그 색 ID
            var kinds = 0
            var lastColor = -1
            for (c in 0 until M) {
                if (box[i][c] > 0) {
                    kinds++
                    lastColor = c
                    if (kinds >= 2) break
                }
            }

            when {
                kinds == 0 -> Unit
                kinds >= 2 -> moves++                  // 혼합 -> 비워야 함
                else -> {                               // kinds == 1
                    val color = lastColor
                    if (!used[color]) used[color] = true
                    else moves++                       // 같은 색 대표 이미 있음 -> 비워야 함
                }
            }
        }
        answer = min(answer, moves)
    }

    println(answer)
}
