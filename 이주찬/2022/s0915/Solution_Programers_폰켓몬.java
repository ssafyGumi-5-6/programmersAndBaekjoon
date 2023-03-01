import java.util.Arrays;

public class Solution_Programers_폰켓몬 {
    public static void main(String[] args) {
        Solution_폰켓몬 sol = new Solution_폰켓몬();
        int[][] input = {
                { 3, 1, 2, 3 },
                { 3, 3, 3, 2, 2, 4 },
                { 3, 3, 3, 2, 2, 2 }
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println(sol.solution(input[i]));
        }
    }
}
class Solution_폰켓몬 {
    public int solution(int[] nums) {
            int answer = 0;
            int len = nums.length;
            int half = len/2;
            int[] result = Arrays.stream(nums).distinct().toArray();
            int setLen = result.length;
            if(setLen > half) answer = half;
            else answer = setLen;
            return answer;
        }
}