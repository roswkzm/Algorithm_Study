class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var successCountList = -1

        fun backtrack(currentFatigue: Int, participationDungeon: MutableList<IntArray>) {
            if (participationDungeon.size > dungeons.size) {
                return
            }
            successCountList = maxOf(successCountList, participationDungeon.size)
            for (dungeon in dungeons) {
                if (dungeon !in participationDungeon && currentFatigue >= dungeon[0]) {
                    participationDungeon.add(dungeon)
                    backtrack(currentFatigue - dungeon[1], participationDungeon)
                    participationDungeon.removeAt(participationDungeon.size - 1)
                }

            }

        }

        backtrack(k, mutableListOf())

        return successCountList
    }
}