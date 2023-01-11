import java.util.Stack;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = 0;
        Stack<Character> stack = new Stack();
        for(int i = 0; i < length; i++) {
            stack.clear();
            int count = 0;
            for(int j = 0; j < length; j++) {
                char c = s.charAt((i + j) % length);
                if(c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                    count++;
                } else {
                    if(stack.size() == 0 || !(c - 2 == stack.peek() || c - 1 == stack.peek())) break;
                    else {
                        stack.pop();
                        count++;
                    }
                }
            }
            
            if(stack.size() == 0 && count == length) answer++;
        }
        return answer;
    }
}