// https://school.programmers.co.kr/learn/courses/30/lessons/147355

fun main() {
    solution("3141592", "271")
    solution("500220839878", "7")
    solution("10203", "15")
}

fun solution(t: String, p: String): Int {
    var answer: Int = 0

    for (i : Int in 0 until t.length-p.length + 1){
        var subString : String = t.substring(i,i+p.length)
        if (subString.toLong() <= p.toLong()){
            answer++
        }
    }
    println(answer)
    return answer
}