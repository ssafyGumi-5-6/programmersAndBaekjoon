import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
word	result
"AAAAE"	6
"AAAE"	10
"AAAEA" 11
"I"	    1563
"EIO"	1189
 */

public class Solution_Programers_사전모음 {
    public static void main(String[] args) {
        Solution_사전모음 solution = new Solution();
        String[] input = {
            "AAAAE",
            "AAAE",
            "AAAEA",
            "I",
            "EIO"
        };
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = solution.solution(input[i]);
            System.out.println(output[i]);
        }
    }
}

class Solution_사전모음 {
    static List<String> list = new ArrayList<String>();

    public int solution(String word) {
        int answer = 0;
        char[] ss = { 'A', 'E', 'I', 'O', 'U' };

        for (int i = 1; i <= 5; i++) {
            dfs(0, 5, i, ss, new char[i]);
        }
        Collections.sort(list);

        // for (int i = 0; i < 30; i++) {
        //     System.out.println(list.get(i));
        // }

        answer = list.indexOf(word) + 1;
        return answer;
    }
    
    static void dfs(int cnt, int n, int r, char[] input, char[] arr) {
        if (cnt == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(arr[i]);
            }
            if (!list.contains(sb.toString())) {
            list.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[cnt] = input[i];
            dfs(cnt + 1, n, r, input, arr);
        }
    }
}