fun main() {
    val gradeMap = mapOf(
        "A+" to 4.5, "A0" to 4.0,
        "B+" to 3.5, "B0" to 3.0,
        "C+" to 2.5, "C0" to 2.0,
        "D+" to 1.5, "D0" to 1.0,
        "F" to 0.0
    )

    var totalScore = 0.0
    var weightedSum = 0.0

    repeat(20) {
        val (name, score, grade) = readLine()!!.split(" ")
        if (grade != "P") {
            val numericScore = score.toDouble()
            val gradePoint = gradeMap.getValue(grade)
            totalScore += numericScore
            weightedSum += numericScore * gradePoint
        }
    }

    println(if (totalScore == 0.0) 0.0 else weightedSum / totalScore)
}
