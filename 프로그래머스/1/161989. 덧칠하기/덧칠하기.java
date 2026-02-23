class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;      // 칠한 횟수
        int painted = 0;    // 현재 어디까지 칠해졌는지

        for (int s : section) {
            if (s > painted) {
                count++;
                painted = s + m - 1;
            }
        }

        return count;
    }
}