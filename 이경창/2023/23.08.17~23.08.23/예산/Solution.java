package 예산;

import java.util.*;
import java.io.*;

public class Solution {

    private static int N;
    private static int M;
    private static long sum;
    private static int[] arr;

    static int upperBound() {

        // 예산을 그냥 줄 수 있으면 바로 반환
        if (sum <= M) {
            return arr[N - 1];
        }

        int start = 0;
        int end = M;

        while (start <= end) {
            int current = 0;
            int mid = (start + end) / 2; // 상한가

            for (int i = 0; i < N; i++) {
                if (arr[i] > mid)
                    current += mid;
                else
                    current += arr[i];
            }

            // 현재 상한가로 예산을 맞추지 못할 경우에
            if (current > M) {
                end = mid - 1;
            }
            // 현재 상한가로 예산을 맞추기 부족함
            else if (current < M){
                start = mid + 1;
            }
            else
                return mid;
        }
        return end;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);

        M = Integer.parseInt(reader.readLine());

        // 0 ~ findIndex - 1 까지는 더한 값을 빼줌

        System.out.println(upperBound());

        reader.close();
    }
}
