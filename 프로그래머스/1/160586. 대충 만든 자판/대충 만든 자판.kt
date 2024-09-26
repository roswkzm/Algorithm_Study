import kotlin.math.min

class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        var keyCodeMap = mutableMapOf<Char, Int>()

        // 자판에서 Char을 Key로 가지고 최소 횟수를 value로 Map
        keymap.map { keyCode ->
            keyCode.mapIndexed { index, keyChar ->
                keyCodeMap[keyChar] =
                    min(keyCodeMap.getOrDefault(keyChar, Int.MAX_VALUE), index + 1)
            }
        }

        for (targetWord in targets) {
            var totalWordPressed = 0
            for (char in targetWord) {
                // 만들수 없는 단어라면
                if (!keyCodeMap.containsKey(char)) {
                    totalWordPressed = -1
                    break
                } else {
                    totalWordPressed += keyCodeMap[char]!!
                }
            }
            answer.add(totalWordPressed)
        }
        return answer.toIntArray()
    }
}