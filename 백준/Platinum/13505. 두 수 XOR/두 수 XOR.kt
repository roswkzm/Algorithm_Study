class TrieNode {
    val children = Array<TrieNode?>(2) { null }
}

fun insert(root: TrieNode, num: Int) {
    var curr = root
    for (i in 31 downTo 0) {
        val bit = (num shr i) and 1
        if (curr.children[bit] == null) {
            curr.children[bit] = TrieNode()
        }
        curr = curr.children[bit]!!
    }
}

fun maxXor(root: TrieNode, num: Int): Int {
    var curr = root
    var xor = 0
    for (i in 31 downTo 0) {
        val bit = (num shr i) and 1
        val opposite = bit xor 1
        if (curr.children[opposite] != null) {
            xor = xor or (1 shl i)
            curr = curr.children[opposite]!!
        } else {
            curr = curr.children[bit]!!
        }
    }
    return xor
}

fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map { it.toInt() }

    val root = TrieNode()
    var result = 0

    for (num in nums) {
        insert(root, num)
    }

    for (num in nums) {
        result = maxOf(result, maxXor(root, num))
    }

    println(result)
}
