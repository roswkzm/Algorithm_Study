class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val ticketMap =
            tickets.groupBy({ it[0] }, { it[1] }).mapValues { it.value.sorted().toMutableList() }
        println(ticketMap)
        val route = mutableListOf<String>()
        val ticketCount = tickets.size

        fun dfs(current: String): Boolean {
            route.add(current)
            println(route)
            if (route.size == ticketCount + 1) return true

            if (ticketMap.containsKey(current)) {
                val destinations = ticketMap[current] ?: mutableListOf()
                for (i in destinations.indices) {
                    val next = destinations.removeAt(i)
                    if (dfs(next)) return true
                    destinations.add(i, next)
                }
            }

            route.removeAt(route.size - 1)
            return false
        }

        dfs("ICN")

        return route.toTypedArray()
    }
}