fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val maxSize = 100001
    val dist = IntArray(maxSize) { Int.MAX_VALUE }
    val deque = ArrayDeque<Int>()

    deque.add(n)
    dist[n] = 0

    while (deque.isNotEmpty()) {
        val curr = deque.removeFirst()

        val double = curr * 2
        if (double < maxSize && dist[double] > dist[curr]) {
            dist[double] = dist[curr]
            deque.addFirst(double)
        }

        val next = curr + 1
        if (next < maxSize && dist[next] > dist[curr] + 1) {
            dist[next] = dist[curr] + 1
            deque.addLast(next)
        }

        val prev = curr - 1
        if (prev >= 0 && dist[prev] > dist[curr] + 1) {
            dist[prev] = dist[curr] + 1
            deque.addLast(prev)
        }
    }
    println(dist[k])
}