class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer: Int = 0
        data.sortWith(compareBy<IntArray> { it[col - 1] }.then(compareByDescending { it[0] }))

        val filterData =
            data.mapIndexed { index, ints -> ints.toMutableList().map { it % (index + 1) }.sum() }
                .filterIndexed { index, _ -> index in row_begin -1 .. row_end -1}

        filterData.forEach { si ->
            answer = answer xor si
        }

        return answer
    }
}