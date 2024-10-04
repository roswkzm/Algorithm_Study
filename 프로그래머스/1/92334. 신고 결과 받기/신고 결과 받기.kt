class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        // 유저별 신고당한 횟수를 가진 Map
        val reportResult = id_list.map { it to 0 }.toMap().toMutableMap()
        // 누가 누굴 신고했는지 저장하는 변수
        val reportList = report.distinct().map { it.split(" ")[0] to it.split(" ")[1] }
        reportList.forEach { reportResult[it.second] = reportResult.getValue(it.second) + 1 }
        val deletePerson = reportResult.filter { it.value >= k }.map { it.key }

        return id_list.map { userId->
            var mailCount = 0
            reportList.forEach {
                if (userId == it.first && deletePerson.contains(it.second)){
                    mailCount++
                }
            }
            mailCount
        }.toIntArray()
    }
}