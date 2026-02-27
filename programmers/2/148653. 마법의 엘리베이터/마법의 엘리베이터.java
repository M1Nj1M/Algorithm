class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int x = storey / 10;   // 10^x
            int y = storey % 10;   // 나머지

            if (y > 5) {
                // 올림) y를 10으로 만들기
                answer += (10 - y);
                storey = x + 1;
            } else if (y < 5) {
                // 내림) y를 0으로 만들기
                answer += y;
                storey = x;
            } else { // y == 5
                int next = x % 10;
                if (next >= 5) {
                    answer += 5;
                    storey = x + 1;
                } else {
                    answer += 5;
                    storey = x;
                }
            }
        }

        return answer;
    }
}