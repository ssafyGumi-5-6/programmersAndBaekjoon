package 용액;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Solution {

    private static int N;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        List<Long> list = new ArrayList<>();
        while(tokenizer.hasMoreTokens()) list.add(Long.parseLong(tokenizer.nextToken()));

        arr = list.stream().mapToLong(Long::longValue).toArray();

        int leftIndex = 0;
        int rightIndex = N - 1;

        int leftResult = 0;
        int rightResult = N - 1;

        long answer = Long.MAX_VALUE;

        while(leftIndex < rightIndex){
            long temp = arr[leftIndex] + arr[rightIndex];

            if(Math.abs(temp) < answer){
                leftResult = leftIndex;
                rightResult = rightIndex;
                answer = Math.abs(temp);
            }

            if(temp == 0) break;
            else if(temp < 0) leftIndex += 1;
            else rightIndex -= 1;
        }

        System.out.println(arr[leftResult] + " " + arr[rightResult]);
        reader.close();
    }
}
