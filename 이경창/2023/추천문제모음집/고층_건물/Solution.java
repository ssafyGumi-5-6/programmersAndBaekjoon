package 고층_건물;

import java.util.*;
import java.io.*;

public class Solution {

    private static int N;
    private static int[] arr;

    private static int getMaxBuildingCount(int index){
        int count = 0;
        double targetSlope = 0;

        // 선분의 기울기 = (건물 A 높이 - 건물 B 높이) / (건물 A와 B의 거리)

        // 왼쪽은 기울기가 + (기울기 작은 값)
        for(int i = index - 1; i >= 0; i--){
            double slope = (double) (arr[index] - arr[i]) / (index - i);
            if(i == index - 1 || targetSlope > slope){
                count++;
                targetSlope = slope;
            }
        }

        // 오른쪽은 기울기가 - (기울기 큰 값)
        for(int i = index + 1; i < N; i++){
            double slope = (double) (arr[index] - arr[i]) / (index - i);
            if(i == index + 1 || targetSlope < slope){
                count++;
                targetSlope = slope;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        arr = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int answer = 0;

        for(int i = 0; i < N; i++){
            answer = Math.max(answer, getMaxBuildingCount(i));
        }

        System.out.println(answer);

        reader.close();
    }
}
