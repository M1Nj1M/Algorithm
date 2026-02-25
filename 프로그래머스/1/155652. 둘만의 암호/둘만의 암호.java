class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder ans = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int cnt = 0;
            while (cnt < index) {
                ch = (ch == 'z') ? 'a' : (char)(ch + 1);
                if (skip.indexOf(ch) == -1) cnt++; // skip 아니면 카운트
            }
            ans.append(ch);
        }
        return ans.toString();
    }
}