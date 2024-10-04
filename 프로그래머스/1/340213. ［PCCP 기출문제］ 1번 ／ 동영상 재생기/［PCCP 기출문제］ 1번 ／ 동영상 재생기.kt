import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Solution {
    fun solution(
        video_len: String,
        pos: String,
        op_start: String,
        op_end: String,
        commands: Array<String>
    ): String {
        val suffixHour = "00:"
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        var currentPos = LocalTime.parse(suffixHour + pos, timeFormatter)
        val videoLen = LocalTime.parse(suffixHour + video_len, timeFormatter)
        val opStart = LocalTime.parse(suffixHour + op_start, timeFormatter)
        val opEnd = LocalTime.parse(suffixHour + op_end, timeFormatter)
        val videoStart = LocalTime.parse(suffixHour + "00:00", timeFormatter)

        if (currentPos >= opStart && currentPos < opEnd) {
            currentPos = opEnd
        }

        for (command in commands) {
            when (command) {
                "next" -> {
                    if (currentPos.plusSeconds(10) > videoLen) currentPos =
                        videoLen else currentPos = currentPos.plusSeconds(10)
                }

                "prev" -> {
                    if (currentPos.minusSeconds(10) > currentPos) currentPos =
                        videoStart else currentPos = currentPos.minusSeconds(10)
                }
            }

            if (currentPos >= opStart && currentPos < opEnd) {
                currentPos = opEnd
            }
        }

        val mmssFormatter = DateTimeFormatter.ofPattern("mm:ss")
        return currentPos.format(mmssFormatter)
    }
}