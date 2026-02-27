import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = 0;

        for (int x = 0; x < n; x++) {
            String rotated = s.substring(x) + s.substring(0, x);
            if (isValid(rotated)) answer++;
        }

        return answer;
    }

    private boolean isValid(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 여는 괄호면 push
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } 
            // 닫는 괄호면 top과 매칭되는지 확인
            else {
                if (stack.isEmpty()) return false;

                char top = stack.peek();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }

                stack.pop();
            }
        }

        // 끝까지 봤는데 여는 괄호가 남아있으면 실패
        return stack.isEmpty();
    }
}