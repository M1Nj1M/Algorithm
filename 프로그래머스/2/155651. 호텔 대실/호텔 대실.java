import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        // 1) 시간을 분 단위로 바꿔서 저장: [start, end]
        int n = book_time.length;
        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            times[i][0] = toMin(book_time[i][0]); // 시작 시간(분)
            times[i][1] = toMin(book_time[i][1]); // 종료 시간(분)
        }

        // 2) 시작 시간 기준으로 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // 3) "방이 다음에 사용 가능한 시간"을 담는 최소 힙
        //    (가장 빨리 비는 방 시간을 peek()로 바로 확인)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 4) 예약을 하나씩 처리
        for (int[] t : times) {
            int start = t[0];
            int end = t[1];

            // 가장 빨리 비는 방이 있고, 그 방이 start 이전(또는 같게) 비면 재사용 가능
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll(); // 그 방 사용(빼기)
            }

            // 이번 손님 사용 후 청소 10분까지 포함해서 "다음 사용 가능 시간" 넣기
            pq.offer(end + 10);
        }

        // pq에 남아있는 개수 = 필요한 최소 객실 수
        return pq.size();
    }

    // "HH:MM" -> 분으로 변환하는 함수
    private int toMin(String s) {
        String[] parts = s.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return hh * 60 + mm;
    }
}