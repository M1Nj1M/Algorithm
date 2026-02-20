import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = toSec(video_len);
        int now = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);
        

        for (String cmd : commands) {
            // 명령 수행 전 자동 스킵
            now = skipOpening(now, opStart, opEnd);

            if (cmd.equals("prev")) {
                now = Math.max(0, now - 10);
            } else { // "next"
                now = Math.min(videoLen, now + 10);
            }

            // 명령 수행 후 자동 스킵
            now = skipOpening(now, opStart, opEnd);
        }

        return toTime(now);
    }

    private int skipOpening(int now, int opStart, int opEnd) {
        if (opStart <= now && now <= opEnd) {
            return opEnd;
        }
        return now;
    }

    private int toSec(String time) {
        int mm = Integer.parseInt(time.substring(0, 2));
        int ss = Integer.parseInt(time.substring(3, 5));
        return mm * 60 + ss;
    }

    private String toTime(int sec) {
        int mm = sec / 60;
        int ss = sec % 60;
        return String.format("%02d:%02d", mm, ss);
    }
}