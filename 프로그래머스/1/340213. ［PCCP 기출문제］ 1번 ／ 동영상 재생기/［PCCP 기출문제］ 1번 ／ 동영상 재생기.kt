class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {

        // "mm:ss" 문자열을 초로 변환하는 함수
        fun toSeconds(time: String): Int {
            val (mm, ss) = time.split(":").map { it.toInt() }
            return mm * 60 + ss
        }

        // 초를 "mm:ss" 문자열로 변환하는 함수
        fun toMMSS(seconds: Int): String {
            val mm = seconds / 60
            val ss = seconds % 60
            return "%02d:%02d".format(mm, ss)
        }

        // 주어진 값들을 초로 변환
        val videoLen = toSeconds(video_len)
        var currentPos = toSeconds(pos)
        val opStart = toSeconds(op_start)
        val opEnd = toSeconds(op_end)

        // 오프닝 구간에 있을 경우 오프닝 끝으로 이동
        if (currentPos in opStart..opEnd) {
            currentPos = opEnd
        }

        // 명령어 처리
        for (command in commands) {
            when (command) {
                "prev" -> {
                    currentPos = maxOf(0, currentPos - 10) // 10초 전으로 이동, 최소 0초
                }
                "next" -> {
                    currentPos = minOf(videoLen, currentPos + 10) // 10초 후로 이동, 최대 동영상 끝
                }
            }

            // 오프닝 구간에 있을 경우 오프닝 끝으로 이동
            if (currentPos in opStart..opEnd) {
                currentPos = opEnd
            }
        }

        // 결과를 "mm:ss" 형식으로 변환하여 반환
        return toMMSS(currentPos)
    }
}