package 동전1;

import java.io.*;
import java.util.*;

public class Solution2 {

    private static int n, k;
    private static long[] dp;
    private static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        arr = new int[n];
        dp = new long[k+1];

        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(arr);
        dp[0] = 1;

        for(int i = 0; i < n; i++){
            System.out.println(i + " 시작");
            for(int j = arr[i]; j <= k; j++){
                dp[j] += dp[j - arr[i]];
                System.out.println(j + " " + dp[j] + " " + dp[j - arr[i]]);
            }
        }


        System.out.println(dp[k]);


        reader.close();
    }
}
