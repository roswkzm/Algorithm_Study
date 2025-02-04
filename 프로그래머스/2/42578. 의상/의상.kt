class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 0
        val clothesMap = clothes.groupBy({it[1]}, {it[0]})
        
        val combination = clothesMap.values.fold(1) { acc, clothList -> 
            acc * (clothList.size + 1)}
        
        return combination - 1
    }
}