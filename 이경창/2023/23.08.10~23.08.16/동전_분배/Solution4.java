package 동전_분배;

import java.io.*;
import java.util.*;

public class Solution4{

    private static int N;
    private static boolean[] dp;

    public static void main(String[] args) throws IOException {
        // Map key 기준으로 정렬하고
        // 만약 더한 값에서 뺀 값과 같은 결과라면 1 break;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        for(int tk = 1; tk <= 3; tk++){
            N = Integer.parseInt(reader.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            dp = new boolean[100010];

            int sumOfMoney = 0;

            for(int i = 0; i < N; i++){
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int money = Integer.parseInt(tokenizer.nextToken());
                int count = Integer.parseInt(tokenizer.nextToken());

                map.put(money, count);

                for(int k = 1 ; k <= count; k++) dp[sumOfMoney + money * k] = true;
                sumOfMoney += money * count;
            }

            List<Integer> list = new ArrayList<>(map.keySet());

            Collections.sort(list);

            if(sumOfMoney % 2 == 1){
                builder.append(0).append("\n");
                continue;
            }

            for(int i = 0 ; i < list.size(); i++){
                int money = list.get(i);
                int count = map.get(list.get(i));

                for(int curMoney = sumOfMoney; curMoney >= money; curMoney--){
                    if(dp[curMoney - money]){
                        for(int k = 1; k <= count && (k * money + curMoney) <= 50000; k++){
                            dp[k * money + curMoney] = true;
                        }
                    }
                }
            }

            if(dp[sumOfMoney / 2]) builder.append(1).append("\n");
            else builder.append(0).append("\n");

        }


        System.out.print(builder);

        reader.close();

    }
}
