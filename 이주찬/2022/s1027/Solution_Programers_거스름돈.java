package 이주찬.s1027;

import java.util.Arrays;

public class Solution_Programers_거스름돈 {
    public static void main(String[] args) {
        Solution_거스름돈 sol = new Solution_거스름돈();
        System.out.println(sol.solution(5, new int[] { 1, 2, 5 }));
    }
}

class Solution_거스름돈 {
    static int ans;

    public int solution(int n, int[] money) {
        ans = 0;
        int len = money.length;
        Arrays.sort(money);
        comb(0, n, money, new int[30], 0);
        return ans;
    }

    static void comb(int sum, int n, int[] money, int[] input, int cnt) {
        if (sum > n) {
            return;
        } else if (sum == n) {
            ans++;
            System.out.println(Arrays.toString(input));
            return;
        }
        for (int i = 0, len = money.length; i < len; i++) {
            input[cnt] = money[i];
            comb(sum + money[i], n, money, input, cnt + 1);
        }
    }
}