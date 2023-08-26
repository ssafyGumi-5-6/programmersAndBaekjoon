package 블로그;

import java.io.*;
import java.util.*;


public class Solution2 {

    private static int N, X;
    private static int[] arr;

    private static int count;
    private static int sum;
    private static int maxValue;

    private static int[] findSum(){
        int start = 0;
        int end = 0;
        int sum = 0;

        while(start < arr.length){
            if(end < arr.length && end < start + X){
                end += 1;
            }else{
                sum += arr[start];
                if(start >= X){
                    sum -= arr[start - X];
                }
                start += 1;

                if(maxValue < sum){
                    maxValue = sum;
                    count = 1;
                }else if(start > X && maxValue == sum) count += 1;
            }
        }

        return new int[]{maxValue, count};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        X = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N];

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] result = findSum();

        if(result[0] == 0) System.out.println("SAD");
        else{
            System.out.println(result[0]);
            System.out.println(result[1]);
        }

    }
}
