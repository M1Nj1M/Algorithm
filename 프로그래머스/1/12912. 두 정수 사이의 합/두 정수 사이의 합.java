class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        // 풀이 1)
        /*
        if(a < b) {
            for(int i = a; i <= b; i++) {
                answer += i;
            }    
        } else {
            for(int i = b; i <= a; i++) {
                answer += i;
            }
        }
        return answer;
        */
        
        // 풀이 2
        /*
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) answer += i;
        return answer;
        */
        
        // 풀이 3
        long min = Math.min(a, b);
        long max = Math.max(a, b);
        return (min + max) * (max - min + 1) / 2;
    }
}