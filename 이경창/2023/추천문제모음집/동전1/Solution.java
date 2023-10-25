package 동전1;

import java.io.*;
import java.util.*;

public class Solution {

    private static int n, k;
    private static int[] dollar;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        dp = new int[k + 1];
        dollar = new int[n];

        for(int i =0 ; i < n ;i++){
            dollar[i] = Integer.parseInt(reader.readLine());
        }

        dp[0] = 1;
        Arrays.sort(dollar);

        for(int i = 0; i < dollar.length; i++){
            for(int j = dollar[i]; j <= k; j++){
                dp[j] += dp[j - dollar[i]];
            }
        }

        System.out.println(dp[k]);

        reader.close();
    }
}
