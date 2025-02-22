import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var signs: Array<Char>  // 부등호 저장
private lateinit var visited: BooleanArray  // 방문 여부 체크
private val results = mutableListOf<String>()  // 가능한 숫자 조합 저장

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().toInt()
    signs = br.readLine().split(" ").map { it[0] }.toTypedArray()
    visited = BooleanArray(10)

    // 백트래킹 실행 (0~9 중에서 선택)
    dfs(k, "")

    // 결과 출력 (최소값, 최대값)
    results.sort()
    println(results.last())  // 최대값
    println(results.first())  // 최소값
}

private fun dfs(k: Int, numStr: String) {
    if (numStr.length == k + 1) {
        results.add(numStr)
        return
    }

    for (i in 0..9) {
        if (!visited[i]) {  // 방문하지 않은 숫자라면
            if (numStr.isEmpty() || checkCondition(numStr.last(), i, numStr.length - 1)) {
                visited[i] = true
                dfs(k, numStr + i)
                visited[i] = false
            }
        }
    }
}

// 부등호 조건 검사
private fun checkCondition(prev: Char, curr: Int, idx: Int): Boolean {
    return when (signs[idx]) {
        '<' -> prev - '0' < curr
        '>' -> prev - '0' > curr
        else -> false
    }
}
