import kotlin.math.sqrt

class Solution {
    fun solution(numbers: String): Int {
        var answer = mutableSetOf<String>()
        val numberList = numbers.map{ it.digitToInt() }
        
        fun backtrack(indexList : MutableList<Int>, word : String) {
            if(word.isNotEmpty() && word.toInt() > 1 && word.first() != '0'){
                if(isPrime(word.toInt())){
                    answer.add(word)
                }
            }
            
            for(i in numbers.indices) {
                if(i !in indexList){
                    indexList.add(i)
                    backtrack(indexList, word + numbers[i])
                    indexList.removeLast()
                }
            }
        }
        
        backtrack(mutableListOf(), "")
        
        return answer.size
    }
    
    private fun isPrime(n : Int) : Boolean {
        if(n < 2) return false
        for(i in (2..sqrt(n.toDouble()).toInt())) {
            if(n % i == 0) return false 
        }
        
        return true
    }
}