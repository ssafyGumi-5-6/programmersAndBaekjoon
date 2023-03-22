package s1108;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Solution_Programers_괄호회전하기
 */
public class Solution_Programers_괄호회전하기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] input = { "[](){}", "}]()[{", "[)(]", "}}}" };
        for (int i = 0; i < input.length; i++) {
            System.out.println(sol.solution(input[i]));
        }
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            dq.addLast(s.charAt(i));
        }
        for (int i = 0; i < dq.size(); i++) {
            if (isRight(dq))
                answer++;
            dq.addLast(dq.removeFirst());
        }
        return answer;
    }

    static boolean isRight(Deque<Character> s) {
        int len = s.size();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            char tmp = s.removeFirst();
            s.addLast(tmp);
            if (st.isEmpty()) {
                st.push(tmp);
                continue;
            }
            char tmp2 = st.peek();
            if (tmp == '}' && tmp2 == '{' || tmp == ']' && tmp2 == '[' || tmp == ')' && tmp2 == '(') {
                st.pop();
            } else {
                st.push(tmp);
            }
        }
        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}