class Solution {
    fun solution(name: String): Int {
        var answer = 0

        if (name.all { it == 'A' }) return 0

        for (char in name) {
            val up = char - 'A'
            val down = 26 - up
            answer += minOf(up, down)
        }

        var minMove = name.length - 1
        for (i in name.indices){
            if (name[i] != 'A'){
                var next = i + 1
                while (next < name.length && name[next] == 'A'){
                    next++
                }
                val move = i + name.length - next + minOf(i, name.length - next)
                minMove = minOf(minMove, move)
            }
        }

        return answer + minMove
    }
}