class Solution {
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        var answer = mutableListOf<IntArray>()
        val minDiscount = users.minOf { it[0] }
        val discountRate = listOf(10, 20, 30, 40).filter { it >= minDiscount }
        val discountCombination = mutableListOf<List<Int>>()

        fun backtrack(list: MutableList<Int>) {
            if (list.size == emoticons.size) {
                discountCombination.add(list.toList())
                return
            }
            for (i in discountRate.indices) {
                list.add(discountRate[i])
                backtrack(list)
                list.removeAt(list.size - 1)
            }
        }
        backtrack(mutableListOf())

        for (discountList in discountCombination) {
            val availableUser = intArrayOf(0, 0)
            val discountByEmoticonsPrice =
                emoticons.mapIndexed { index, i -> i * (100 - discountList[index]) / 100 }
                    .mapIndexed { index, i -> discountList[index] to i }
            for (user in users) {
                val buyEmoticonPrice =
                    discountByEmoticonsPrice.filter { it.first >= user[0] }.map { it.second }
                        .sumOf { it }

                if (buyEmoticonPrice != 0) {
                    if (buyEmoticonPrice >= user[1]) {
                        availableUser[0] += 1
                    } else {
                        availableUser[1] += buyEmoticonPrice
                    }
                }
            }
            answer.add(availableUser)
        }

        val sortedAnswer =
            answer.sortedWith(compareByDescending<IntArray> { it[0] }.thenByDescending { it[1] })
        return sortedAnswer.first()
    }
}