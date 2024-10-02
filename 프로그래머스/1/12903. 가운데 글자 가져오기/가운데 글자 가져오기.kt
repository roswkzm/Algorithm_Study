class Solution {
    fun solution(s: String): String {
        val length = s.length
        val middle = length / 2
        return if (length % 2 == 0){
            s.substring(middle -1, middle + 1)
        } else {
            s[middle].toString()
        }
    }
}