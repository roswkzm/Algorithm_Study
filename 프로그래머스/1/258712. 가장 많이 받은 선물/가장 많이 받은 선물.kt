class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val nextMonthGift = IntArray(friends.size)
        // 선물 전송 목록 Map
        val sendGiftMap = friends.associateWith { myName ->
            gifts.filter { it.split(" ")[0] == myName }.map { it.split(" ")[1] }
        }
        // 선물지수 Map
        val giftJisoo = friends.associateWith { myName ->
            val sendGift = gifts.count { it.split(" ")[0] == myName }
            val receivedGift = gifts.count { it.split(" ")[1] == myName }
            sendGift - receivedGift
        }

        for ((index, myName) in friends.withIndex()) {
            var wantGiftCount = 0
            for (giftPerson in sendGiftMap) {
                // 나 자신이 나자신한테 하는거 제외
                if (friends[index] == giftPerson.key) continue
                
                val receivedGiftCount = giftPerson.value.count { it == myName } // 선물받은 개수
                val sendGiftCount = sendGiftMap.getValue(myName).count { it == giftPerson.key } // 선물한 개수
                val myJisoo = giftJisoo.getValue(myName) // 내 선물지수
                val otherJisoo = giftJisoo.getValue(giftPerson.key) // 다른사람 선물지수
                
                if (sendGiftCount > receivedGiftCount) {
                    wantGiftCount++
                } else if (sendGiftCount == receivedGiftCount && myJisoo > otherJisoo) {
                        wantGiftCount++
                }
            }
            nextMonthGift[index] = wantGiftCount
        }
        return nextMonthGift.maxOf { it }
    }
}