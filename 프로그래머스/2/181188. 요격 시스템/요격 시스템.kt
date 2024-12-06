class Solution {
    fun solution(targets: Array<IntArray>): Int {
        targets.sortBy { it[1] }

        var shots = 1
        var lastShot = targets[0][1]

        for (i in 1 until targets.size) {
            val target = targets[i]

            if (lastShot <= target[0]) {
                lastShot = target[1]
                shots++
            }
        }

        return shots
    }
}