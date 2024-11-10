import kotlin.math.abs

class Solution {
    fun solution(expression: String): Long {
        var answer = mutableListOf<Long>()
        var priorityList = mutableListOf<List<String>>()

        val splitRegex = "\\d+|[+\\-*]".toRegex()
        val operationRegex = "[+\\-*]".toRegex()
        val express = splitRegex.findAll(expression)
            .map { it.value }
            .toList()
        val operation = operationRegex.findAll(expression)
            .map { it.value }
            .toSet()

        fun backtrack(current: MutableList<String>) {
            if (current.size == operation.size) {
                priorityList.add(current.toList())
                return
            }

            for (op in operation) {
                if (op !in current) {
                    current.add(op)
                    backtrack(current)
                    current.removeAt(current.size - 1)
                }
            }
        }

        backtrack(mutableListOf())

        for (priority in priorityList) {
            val tempList = express.toMutableList()
            for (op in priority) {
                while (op in tempList) {
                    val opIndex = tempList.indexOf(op)
                    var result = 0L
                    println(op)
                    when (op) {
                        "-" -> {
                            result = tempList[opIndex - 1].toLong() - tempList[opIndex + 1].toLong()
                        }

                        "*" -> {
                            result = tempList[opIndex - 1].toLong() * tempList[opIndex + 1].toLong()
                        }

                        "+" -> {
                            result = tempList[opIndex - 1].toLong() + tempList[opIndex + 1].toLong()
                        }
                    }
                    repeat(3) {
                        tempList.removeAt(opIndex - 1)
                    }
                    tempList.add(opIndex - 1, result.toString())
                }
            }
            answer.add(abs(tempList.first().toLong()))
        }

        return answer.maxOf { it }
    }
}