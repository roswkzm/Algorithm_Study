class Solution {
    fun solution(cards: IntArray): Int {
        val boxGroup = mutableSetOf<List<Int>>()

        for (i in cards.indices) {
            val card = cards[i]
            var nextCard = cards[card - 1]
            val visited = mutableListOf<Int>()
            visited.add(card)

            while (true) {
                if (!visited.contains(nextCard)) {
                    visited.add(nextCard)
                    nextCard = cards[nextCard - 1]
                } else {
                    break
                }
            }
            boxGroup.add(visited.sorted())
        }
        val result = boxGroup.map { it.size }.sorted()

        return if (result.size < 2) 0 else result.takeLast(2).reduce { a, b -> a * b }
    }
}