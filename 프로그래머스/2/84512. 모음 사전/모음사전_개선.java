class Solution {
    /*
     * 5^4 + 5^3 + 5^2 + 5^1 + 1 = 781
     * 5^3 + 5^2 + 5^1 + 1 = 156
     * 5^2 + 5^1 + 1 = 31
     * 5^1 + 1 = 6
     * 1
     */

    // 하드코딩 없이 가중치 생성: [781, 156, 31, 6, 1]
    private int[] buildWeight() {
        int[] weight = new int[5];

        for (int i = 0; i < 5; i++) {
            int sum = 0;
            int pow = 1; // 5^0

            // i번째 자리 뒤에 남은 길이: (5 - i)
            for (int k = 0; k < 5 - i; k++) {
                sum += pow;   // 1 + 5 + 25 + ...
                pow *= 5;
            }

            weight[i] = sum;
        }

        return weight;
    }

    public int solution(String word) {
        int[] weight = buildWeight();
        int answer = 0;
        
        // 모음 순서
        String vowels = "AEIOU";

        for (int i = 0; i < word.length(); i++) {
            int index = vowels.indexOf(word.charAt(i));

            answer += index * weight[i] + 1;
        }

        return answer;
    }
}
