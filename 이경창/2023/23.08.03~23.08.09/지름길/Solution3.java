package 지름길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution3 {

    private static int N, D;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        D = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int startPos = Integer.parseInt(tokenizer.nextToken());
            int arrivalPos = Integer.parseInt(tokenizer.nextToken());
            int shortCutLen = Integer.parseInt(tokenizer.nextToken());

            map.putIfAbsent(arrivalPos, new ArrayList<>());
            map.get(arrivalPos).add(new int[]{startPos, shortCutLen});
        }


        int maxLen = 10010;
        int[] dp = new int[maxLen];


        for(int i = 1; i < maxLen; i++){
            dp[i] = dp[i - 1] + 1;

            if(map.containsKey(i)){
                for(int j = 0; j < map.get(i).size(); j++){
                    dp[i] = Math.min(dp[i], dp[map.get(i).get(j)[0]] + map.get(i).get(j)[1]);
                }
            }
        }

        System.out.println(dp[D]);
        reader.close();
    }
}
