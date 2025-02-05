import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        val subContainer = Stack<Int>()
        var currentBox = 1
        var index = 0
        
        while(currentBox <= order.size){
            
            if(currentBox == order[index]){
                index++
            } else {
                subContainer.add(currentBox)
            }
            
            while(subContainer.isNotEmpty() && subContainer.last() == order[index]){
                subContainer.removeLast()
                index++
            }
            
            currentBox++
        }
        
        return index
    }
}