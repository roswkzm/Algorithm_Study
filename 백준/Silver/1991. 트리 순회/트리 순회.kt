fun main() {
    val n = readLine()!!.toInt()
    val tree = mutableMapOf<Char, Pair<Char, Char>>()

    repeat(n) {
        val (parent, left, right) = readLine()!!.split(" ").map { it[0] }
        tree[parent] = left to right
    }

    fun preOrder(node: Char) {
        if (node == '.') return
        print(node)
        preOrder(tree[node]!!.first)
        preOrder(tree[node]!!.second)
    }

    fun inOrder(node: Char) {
        if (node == '.') return
        inOrder(tree[node]!!.first)
        print(node)
        inOrder(tree[node]!!.second)
    }

    fun postOrder(node: Char) {
        if (node == '.') return
        postOrder(tree[node]!!.first)
        postOrder(tree[node]!!.second)
        print(node)
    }

    preOrder('A')
    println()
    inOrder('A')
    println()
    postOrder('A')
    println()
}