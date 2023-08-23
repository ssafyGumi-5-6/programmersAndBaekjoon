package 공통_부분_문자열;

import java.io.*;
import java.util.*;

public class Solution5 {

    private static String s, t;

    private static int lsDistance(char[] c1, char[] c2) {
        int[][] dp = new int[c1.length + 1][c2.length + 1];

        int maxLen = 0;
        int endIndex = -1;
        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }

        if (endIndex == -1) {
            return 0;
        }
        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s = reader.readLine();
        t = reader.readLine();

        System.out.println(lsDistance(s.toCharArray(), t.toCharArray()));

        reader.close();
    }
}
