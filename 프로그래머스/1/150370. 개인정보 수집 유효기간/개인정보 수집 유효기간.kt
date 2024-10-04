import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer = arrayListOf<Int>()

        val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
        var todayDate = LocalDate.parse(today, formatter)
        println(todayDate)
        println(todayDate.plusMonths(10).minusDays(1))

        for ((index, privacy) in privacies.withIndex()) {
            for (term in terms) {
                // 개인정보 수집대상과 유효기간을 알리는 객체가 동일할 경우
                if (privacy.last() == term.first()) {
                    val collectionDate = LocalDate.parse(privacy.split(" ")[0], formatter)
                    val expirationDate =
                        collectionDate.plusMonths(term.split(" ")[1].toLong()).minusDays(1)
                    if (todayDate > expirationDate) {
                        answer.add(index + 1)
                    }
                }
            }
        }

        println(answer)

        return answer.toIntArray()
    }
}