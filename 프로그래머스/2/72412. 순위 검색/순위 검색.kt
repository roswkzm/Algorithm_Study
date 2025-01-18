class Solution {
    val map = HashMap<String, ArrayList<Int>>()

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)

        info.map {
            dfs(0, "", it.split(" "))
        }
        map.values.map { it.sort() }

        query.mapIndexed { index, string->
            val str = string.replace(" and ", "").split(" ")
            if (!map.containsKey(str[0])) {
                answer[index] = 0
            } else {
                answer[index] = binarySearch(map[str[0]]!!, str[1].toInt())
            }
        }
        return answer
    }

    fun dfs(depth: Int, key: String, info: List<String>) {
        if (depth == 4) {
            if (map.containsKey(key)) {
                map[key]!!.add(info[4].toInt())
            } else
                map[key] = arrayListOf(info[4].toInt())
            return
        }
        dfs(depth + 1, "$key-", info)
        dfs(depth + 1, key + info[depth], info)
    }


    fun binarySearch(applicant: List<Int>, target: Int): Int {
        var low = 0
        var high = applicant.lastIndex

        while (low <= high) {
            val mid = (low + high) / 2

            if (applicant[mid] >= target)
                high = mid - 1
            else
                low = mid + 1
        }
        return applicant.size - low
    }
}