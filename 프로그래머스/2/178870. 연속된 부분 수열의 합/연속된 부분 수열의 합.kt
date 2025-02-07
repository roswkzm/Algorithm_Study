class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var left = 0
        var sum = 0
        var minLength = Int.MAX_VALUE
        var result = intArrayOf(-1, -1)
        
        for(right in sequence.indices) {
            sum += sequence[right]
            
            while(sum >= k) {
                if(sum == k) {
                    val currLength = right - left
                    if (currLength < minLength){
                        minLength = currLength
                        result = intArrayOf(left, right)
                    }
                }
                sum -= sequence[left]
                left++
            }
        }
        
        return result
    }
}