class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()

        val sortedGenres = genres.indices
            .groupingBy { genres[it] }
            .fold(0) { acc, i -> acc + plays[i] }
            .entries
            .sortedByDescending { it.value }
            .map { it.key }

        val genresInfo = genres.indices
            .groupBy { genres[it] }
            .mapValues {
                it.value.map { index -> Pair(index, plays[index]) }
            }.map { it.key to it.value.toMutableList() }


        for ((genre, songs) in genresInfo) {
            songs.sortWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first })
        }

        sortedGenres.forEach { bestGenres ->
            val getTwoBestSong =
                genresInfo.filter { it.first == bestGenres }.flatMap { it.second.map { it.first } }
                    .filterIndexed { index, i -> index < 2 }
            answer.addAll(getTwoBestSong)
        }

        return answer.toIntArray()
    }
}