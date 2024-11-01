class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer = mutableListOf<String>()
        val menuMap = mutableMapOf<String, Int>()

        fun backtracking(start: Int, makeMenu: MutableList<Char>, menuList: List<Char>) {
            val makeCourse = makeMenu.joinToString("")
            if (makeMenu.size >= 2) {
                menuMap[makeCourse] = menuMap.getOrDefault(makeCourse, 0) + 1
            }

            for (i in start until menuList.size) {
                makeMenu.add(menuList[i])
                backtracking(i + 1, makeMenu, menuList)
                makeMenu.removeAt(makeMenu.size - 1)
            }
        }

        for (order in orders) {
            val menuList = order.map { it }.sorted()
            backtracking(0, mutableListOf(), menuList)
        }

        for (size in course) {
            val filteredMenus =
                menuMap.filterKeys { it.length == size && menuMap.getValue(it) >= 2 }
            val maxFavorite = filteredMenus.values.maxOrNull() ?: continue
            answer.addAll(filteredMenus.filterValues { it == maxFavorite }.keys)
        }

        return answer.sorted().toTypedArray()
    }
}