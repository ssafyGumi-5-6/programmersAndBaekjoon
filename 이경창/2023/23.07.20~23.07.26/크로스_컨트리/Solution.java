package 크로스_컨트리;

import java.util.*;
import java.io.*;

public class Solution {

    private static int T;
    private static int N;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        T = Integer.parseInt(reader.readLine());

        for (int tk = 1; tk <= T; tk++) {
            N = Integer.parseInt(reader.readLine());
            dp = new int[210][6];

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            List<Integer> list = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) list.add(Integer.parseInt(tokenizer.nextToken()));
            arr = list.stream().mapToInt(Integer::intValue).toArray();

            Map<Integer, Integer> map = new HashMap<>();

            for (int inArr : arr) {
                map.putIfAbsent(inArr, 0);
                map.put(inArr, map.get(inArr) + 1);
            }

            int rank = 1;
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int inArr : arr) {
                // 6인 경우만 문제의 조건에 해당한다.
                if (map.get(inArr) < 6) continue;
                map2.putIfAbsent(inArr, 0);
                map2.put(inArr, map2.get(inArr) + 1);
                if (map2.get(inArr) == 1) dp[inArr][map2.get(inArr) - 1] = rank++;
                else dp[inArr][map2.get(inArr) - 1] = dp[inArr][map2.get(inArr) - 2] + rank++;
            }

            int answer = -1;
            boolean[] visited = new boolean[210];
            for (int inArr : arr) {
//                System.out.println(inArr + " " + visited[inArr]);
                if (map2.getOrDefault(inArr, 0) == 0) continue;
                if (visited[inArr]) continue;
                visited[inArr] = true;
                if (answer == -1) answer = inArr;
                else {
                    if (dp[inArr][4 - 1] < dp[answer][4 - 1]) answer = inArr;
                    else if (dp[inArr][4 - 1] == dp[answer][4 - 1] && dp[inArr][5 - 1] < dp[answer][5 - 1])
                        answer = inArr;
                    else if (dp[inArr][4 - 1] == dp[answer][4 - 1] && dp[inArr][5 - 1] == dp[answer][5 - 1] && dp[inArr][6 - 1] < dp[answer][6 - 1])
                        answer = inArr;
                }
            }
            builder.append(answer).append("\n");
        }
        System.out.print(builder);
        reader.close();
    }
}
