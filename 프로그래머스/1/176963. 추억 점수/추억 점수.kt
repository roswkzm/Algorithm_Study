class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {

        val answer = IntArray(photo.size)
        val yearningMap = mutableMapOf<String, Int>()

        for (i in name.indices){
            yearningMap[name[i]] = yearning[i]
        }

        for (i in photo.indices){
            var score = 0
            for (person in photo[i]){
                score += yearningMap.getOrDefault(person, 0)
            }
            answer[i] = score
        }
        return answer
    }
}