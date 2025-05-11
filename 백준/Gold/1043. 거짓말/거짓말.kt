fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val know = readLine()!!.split(" ").drop(1).map { it.toInt() }
    val parent = IntArray(n + 1) { it }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val px = find(x)
        val py = find(y)
        if (px != py) parent[py] = px
    }

    val parties = mutableListOf<List<Int>>()

    repeat(m) {
        val party = readLine()!!.split(" ").drop(1).map { it.toInt() }
        parties.add(party)
        for (i in 1 until party.size) {
            union(party[0], party[i])
        }
    }

    val knownRoots = know.map { find(it) }.toSet()

    var result = 0
    for (party in parties) {
        if (party.all { find(it) !in knownRoots }) {
            result++
        }
    }

    println(result)
}
