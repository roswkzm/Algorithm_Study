class Solution {
    fun solution(record: Array<String>): Array<String> {
        val answer = mutableListOf<String>()
        val nameMap = mutableMapOf<String, String>()

        record.forEach {
            val (action, userId) = it.split(" ")
            val userName = it.split(" ").getOrNull(2)
            if (userName != null) {
                nameMap[userId] = userName
            }
        }

        record.forEach {
            val (action, userId) = it.split(" ")
            val userName = nameMap.getValue(userId)
            if (action == "Enter") {
                answer.add("${userName}님이 들어왔습니다.")
            } else if (action == "Leave") {
                answer.add("${userName}님이 나갔습니다.")
            }
        }

        return answer.toTypedArray()
    }
}