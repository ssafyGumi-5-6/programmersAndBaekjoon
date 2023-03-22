package y2023.s0302;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_Programers_대충만든자판 {
    public static void main(String[] args) {
        String[][] keymapInput = {
            {"", "BCDZ"},
        };
        String[][] targetsInput = {
            {"AAAZ"},
        };
        Solution sol = new Solution();
        for (int i = 0; i < targetsInput.length; i++) {
            int[] res = sol.solution(keymapInput[i], targetsInput[i]);
            System.out.println(Arrays.toString(res));
        }
    }
    static class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                char curChar = (char) ('A' + i);
                int min = 0;
                for (int j = 0; j < keymap.length; j++) {
                    String tmpStr = keymap[j];
                    for (int q = 0; q < tmpStr.length(); q++) {
                        if (curChar == tmpStr.charAt(q)) {
                            if (min == 0)
                                min = q + 1;
                            else {
                                min = Math.min(min, q + 1);
                            }
                        }
                    }
                }
                map.put(curChar, min);
            }
            for (int i = 0; i < targets.length; i++) {
                String curStr = targets[i];
                int sum = 0;
                for (int j = 0; j < curStr.length(); j++) {
                    char curChar = curStr.charAt(j);
                    if (map.get(curChar) == 0) {
                        sum = 0;
                        break;
                    }
                    sum += map.get(curChar);
                }
                if (sum == 0)
                    answer[i] = -1;
                else answer[i] = sum;
            }
            return answer;
        }
    }
}
