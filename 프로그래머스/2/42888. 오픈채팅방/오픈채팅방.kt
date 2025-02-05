class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        val nameMap = mutableMapOf<String, String>()
        
        record.forEach{
            val (_, userId) = it.split(" ")
            val nickName = it.split(" ").getOrNull(2)
            if(nickName != null) {
            nameMap[userId] = nickName
            }
        }
        
        record.forEach{
            val (task, userId) = it.split(" ")
            val currNickName = nameMap.getValue(userId)
            if(task == "Enter"){
                answer.add("${currNickName}님이 들어왔습니다.")
            } else if(task == "Leave"){
                answer.add("${currNickName}님이 나갔습니다.")
            }
        }
        
        return answer.toTypedArray()
    }
}