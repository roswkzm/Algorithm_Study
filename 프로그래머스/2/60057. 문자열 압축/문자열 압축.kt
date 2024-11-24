class Solution {
    fun solution(s: String): Int {
        var answer = Int.MAX_VALUE

        if (s.length == 1) {
            return 1
        }

        fun compressStringList(list: List<String>): Int {
            val compressed = StringBuilder()
            var current = list[0]
            var count = 1

            for (i in 1 until list.size) {
                if (list[i] == current) {
                    count++
                } else {
                    compressed.append(if (count > 1) "$count$current" else current)
                    current = list[i]
                    count = 1
                }
            }
            compressed.append(if (count > 1) "$count$current" else current)
            return compressed.length
        }

        for (sliceCount in 1..s.length / 2) {
            val makeList = mutableListOf<String>()
            for (index in s.indices step sliceCount) {
                makeList.add(
                    s.slice(index until minOf(index + sliceCount, s.length))
                )
            }
            val compressLength = compressStringList(makeList)
            answer = minOf(answer, compressLength)
        }

        return answer
    }
}