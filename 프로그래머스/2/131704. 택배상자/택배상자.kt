import java.util.Stack

class Solution {
    fun solution(order: IntArray): Int {
        val subContainer = Stack<Int>()
        var currentBox = 1
        var idx = 0

        // 내 상자개수가 택배기사가 원하는 개수랑 같거나 작을때 동안
        while (currentBox <= order.size){
            // 기사가 원하는게 내 손에 있을경우
            if (order[idx] == currentBox){
                idx++
            } else {    // 기사가 원하는게 내손에 없다면 보조 컨테이너에 추가
                subContainer.push(currentBox)
            }

            // 보조 컨테이너가 비어있지 안거나 거기에 기사가 원하는 상자를 바로 꺼낼수 있다면
            while (subContainer.isNotEmpty() && subContainer.peek() == order[idx]){
                subContainer.pop()
                idx++
            }
            // 다음상자로 이동
            currentBox++
        }
        // 남은상자 처리가능하다면 처리
        while (subContainer.isNotEmpty() && subContainer.peek() == order[idx]){
            subContainer.pop()
            idx++
        }

        return idx
    }
}