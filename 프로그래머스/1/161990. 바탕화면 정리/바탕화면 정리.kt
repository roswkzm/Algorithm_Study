import kotlin.math.max
import kotlin.math.min

class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        val answer = mutableListOf(50, 50, 0 ,0)
        val desktop = Array(wallpaper.size){ CharArray(wallpaper[0].length)}

        for (i in wallpaper.indices){
            desktop[i] = wallpaper[i].toCharArray()
            println(desktop[i].contentToString())
        }

        // 가장 왼쪽 위에 있는 Index가 시작점
        // 가정 오른쪽 index + 1  가장 아래쪽 index+ 1 이 끝점

        for (i in desktop.indices){
            for (j in desktop[i].indices){
                if (desktop[i][j] == '#'){
                    answer[0] = min(answer[0], i)
                    answer[1] = min(answer[1], j)
                    answer[2] = max(answer[2], i + 1)
                    answer[3] = max(answer[3], j + 1)
                }
            }
        }

        return answer.toIntArray()
    }
}