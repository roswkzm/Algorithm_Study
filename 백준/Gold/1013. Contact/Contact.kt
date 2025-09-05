import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.regex.Pattern

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val pattern = Pattern.compile("^(100+1+|01)+$")
    val sb = StringBuilder()

    repeat(t) {
        val s = br.readLine().trim()
        if (pattern.matcher(s).matches()) sb.append("YES\n")
        else sb.append("NO\n")
    }
    print(sb.toString())
}
