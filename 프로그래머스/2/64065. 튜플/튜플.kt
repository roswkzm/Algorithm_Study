class Solution {
    fun solution(s: String): IntArray {
        var answer = mutableSetOf<Int>()
        val result = s.substring(2, s.length -2).split("},{").map{ 
            it.split(",").map{ 
                it.toInt()
            }
        }.sortedBy{ it.size }
        
        for(list in result){
            for(i in list){
                answer.add(i)
            }
        }
        
        return answer.toIntArray()
    }
}