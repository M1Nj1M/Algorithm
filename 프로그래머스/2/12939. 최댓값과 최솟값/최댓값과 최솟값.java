class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        
        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int x = Integer.parseInt(arr[i]);
            if (x < min) min = x;
            if (x > max) max = x;
        }

        return min + " " + max;
    }
}