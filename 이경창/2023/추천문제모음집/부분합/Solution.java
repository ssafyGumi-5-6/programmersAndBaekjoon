package 부분합;

import java.io.*;
import java.util.*;

public class Solution {

    private static int N, S;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N];

        tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }


        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

//        System.out.println(Arrays.toString(arr));

        while (left < arr.length) {
            if (right < arr.length && sum < S) {
                sum += arr[right];
                right += 1;
            } else {
//                System.out.println(left + " " + (right - 1) + " " + sum);
                if (sum >= S) answer = Math.min(answer, (right - left));
                sum -= arr[left];
                left += 1;
            }
        }

        answer = (answer == Integer.MAX_VALUE ? 0 : answer);
        System.out.println(answer);


        reader.close();
    }
}
