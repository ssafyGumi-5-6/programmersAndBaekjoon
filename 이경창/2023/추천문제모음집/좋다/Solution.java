package 좋다;

import java.io.*;
import java.util.*;

public class Solution {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        arr = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;

        for(int i = 0; i < N; i++){
            int target = arr[i];
            int left = 0;
            int right = arr.length - 1;

            while(left < right){
                int sum = arr[left] + arr[right];
                if(sum == target){
                     if(left != i && right != i){
                         answer += 1;
                         break;
                     }else if(left == i){
                         left += 1;
                     }else{
                         right -= 1;
                     }
                }else if(sum < target){
                    left += 1;
                }else {
                    right -= 1;
                }
            }
        }

        System.out.println(answer);

    }
}
