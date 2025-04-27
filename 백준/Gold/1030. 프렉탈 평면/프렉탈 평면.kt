fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val s = input[0]
    val n = input[1]
    val k = input[2]
    val r1 = input[3]
    val r2 = input[4]
    val c1 = input[5]
    val c2 = input[6]

    val output = StringBuilder()

    for (i in r1..r2) {
        for (j in c1..c2) {
            var x = i
            var y = j
            var isBlack = false

            var size = 1
            repeat(s) { size *= n }

            while (size > 1) {
                val unit = size / n
                val centerStart = (n - k) / 2
                val centerEnd = centerStart + k

                val cx = (x / unit)
                val cy = (y / unit)

                if (cx in centerStart until centerEnd && cy in centerStart until centerEnd) {
                    isBlack = true
                    break
                }

                x %= unit
                y %= unit
                size = unit
            }

            output.append(if (isBlack) '1' else '0')
        }
        output.append('\n')
    }

    print(output)
}
