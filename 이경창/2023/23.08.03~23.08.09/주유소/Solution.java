package 주유소;

import java.io.*;
import java.util.*;

public class Solution {

    private static int N;
    private static long[] street;
    private static long[] oil;
    private static long[] dp;

    private static List<Integer> input(BufferedReader reader) throws IOException{
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        while(tokenizer.hasMoreTokens()) list.add(Integer.parseInt(tokenizer.nextToken()));
        return list;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        street = input(reader).stream().mapToLong(Integer::intValue).toArray();
        oil = input(reader).stream().mapToLong(Integer::intValue).toArray();

        dp = new long[N];

        dp[0] = street[0] * oil[0];

        long minOil = oil[0];
        for(int i = 1; i < N - 1; i++){
             minOil = Math.min(minOil, oil[i]);
             dp[i] = dp[i - 1] + minOil * street[i];
        }

//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[N - 2]);

        reader.close();
    }
}
