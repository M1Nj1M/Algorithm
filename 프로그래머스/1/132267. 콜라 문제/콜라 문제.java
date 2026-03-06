class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int exchange = n / a;          // 이번에 몇 번 교환?
            int cola = exchange * b;       // 이번에 받은 콜라(=새 빈 병)
            answer += cola;                // 누적
            n = (n % a) + cola;            // 남은 병 + 새로 생긴 병
        }

        return answer;
    }
}