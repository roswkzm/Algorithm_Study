class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.sortedWith(compareBy({it.toCharArray()[n]}, {it})).toTypedArray()
    }
}