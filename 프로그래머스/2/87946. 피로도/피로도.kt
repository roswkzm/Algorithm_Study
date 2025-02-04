class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = -1
        
        fun backtrack(currentFatigue : Int, participantDungeons: MutableList<IntArray>) {
            if (participantDungeons.size > dungeons.size) {
                return
            }
            answer = maxOf(answer, participantDungeons.size)
            
            for(dungeon in dungeons) {
                if(dungeon !in participantDungeons && currentFatigue >= dungeon[0]) {
                    participantDungeons.add(dungeon)
                    backtrack(currentFatigue - dungeon[1], participantDungeons)
                    participantDungeons.remove(dungeon)
                }
            }
        }
        
        backtrack(k, mutableListOf())
        
        return answer
    }
}