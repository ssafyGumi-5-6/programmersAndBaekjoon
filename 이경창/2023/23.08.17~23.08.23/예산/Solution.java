package 예산;

import java.util.*;
import java.io.*;

// 4
//1 1 3 7
//11

// 답이 나오지 않는 예제

public class Solution {

    private static int N;
    private static long M;
    private static int[] arr;

    private static int upperBound(int findData){
        // M을 찾습니다.
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;
            System.out.println("left : " + left + " right : " + right + " mid : " + mid + " findData : " + findData);
            if(findData < arr[mid]) {
                right = mid;
                findData += (findData - arr[left]);
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        while(tokenizer.hasMoreTokens()) list.add(Integer.parseInt(tokenizer.nextToken()));
        arr = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);

        M = Long.parseLong(reader.readLine());

        int findIndex = upperBound((int)M/N);

        // 0 ~ findIndex - 1 까지는 더한 값을 빼줌
        for(int i = 0; i < findIndex; i++) M -= arr[i];

        long[] dp = new long[N];
        dp[0] = arr[0];
        for(int i = 1 ; i < N; i++) dp[i] = dp[i-1] + arr[i];

        int answer = 0;
        // 남은 값으로 나누기 계산, 만약 남은 값의 총합이 빼고남은 M보다 작을 경우 인덱스 마지막 값이 가장 큰 값
        System.out.println("찾은 인덱스 : " + findIndex);
        System.out.println("M : " + M);
        if(dp[N - 1] - dp[findIndex] + arr[findIndex] > M) answer =(int)M / (N - findIndex);
        else answer = arr[N - 1];

        System.out.println(answer);

        reader.close();
    }
}
