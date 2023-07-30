package 주식;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {

    private static int T;
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(reader.readLine());

        for(int tk = 1; tk <= T; tk++){
            N = Integer.parseInt(reader.readLine());
            arr = new int[N];

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int size = tokenizer.countTokens();

            for(int j = 0 ; j < size; j++){
                arr[j] = Integer.parseInt(tokenizer.nextToken());
            }

            int stockPrice = 0; // 현재 가장 큰 값
            int growthPhase = 0; // 구간
            long answer = 0;

            // 뒤에서 부터 확인한다.
            for(int index = N - 1; index >= 0; index--){
                if(stockPrice < arr[index]){
                    answer += ((long) stockPrice * growthPhase);
                    stockPrice = arr[index]; growthPhase = 0;
                }else{
                    growthPhase++;
                    answer -= arr[index];
                }
            }

            if(growthPhase > 0){
                answer += ((long) stockPrice * growthPhase);
            }

            System.out.println(answer);
        }

    }
}