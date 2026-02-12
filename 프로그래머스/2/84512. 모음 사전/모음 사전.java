class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] weight = {781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = 0;

            switch (c) {
                case 'A': index = 0; break;
                case 'E': index = 1; break;
                case 'I': index = 2; break;
                case 'O': index = 3; break;
                case 'U': index = 4; break;
            }

            answer += index * weight[i] + 1;
        }

        return answer;
    }
}