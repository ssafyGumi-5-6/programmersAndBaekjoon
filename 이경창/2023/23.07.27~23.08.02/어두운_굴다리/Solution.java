package 어두운_굴다리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static int N, M;
    private static int[] arr;
    private static int result;

    private static void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        List<Integer> list = new ArrayList<>();

        while(tokenizer.hasMoreTokens()){
            list.add(Integer.parseInt(tokenizer.nextToken()));
        }

        arr = list.stream().mapToInt(Integer::intValue).toArray();
        reader.close();
    }

    public static void main(String[] args) throws IOException {

        input();
        result = Math.max(result, arr[0]);
        result = Math.max(result, N - arr[arr.length - 1]);

        for(int i  = 1; i < arr.length; i++){
            int curResult = (arr[i] - arr[i - 1]) / 2;
            curResult = (arr[i] - arr[i - 1]) % 2 != 0 ? curResult + 1 : curResult;
            result = Math.max(result, curResult);
        }

        System.out.println(result);
    }
}
