package 등수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static int N, P;


    private static int findRanking(int[] arr, int findNumber){
        int high = 0;
        int same = 0;

        for(int i = 0; i < arr.length; i++){
            if(findNumber == arr[i]) same += 1;
            else if(findNumber < arr[i]) high += 1;
            else break;
        }

//        System.out.println("high : " + high + " same : " + same);
        if (high + same < P) return high + 1;
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tokenizer.nextToken());
        int findNumber = Integer.parseInt(tokenizer.nextToken());
        P = Integer.parseInt(tokenizer.nextToken());

        int[] arr;
        arr = new int[N];
        StringBuilder builder = new StringBuilder();
        if(N == 0 && P == 0) builder.append(-1);
        else if(N == 0 && 0 < P) builder.append(1);
        else{
            tokenizer = new StringTokenizer(br.readLine(), " ");

            for(int tk = 1; tk <= N; tk++){
                arr[tk - 1] = Integer.parseInt(tokenizer.nextToken());
            }

            int answer = findRanking(arr, findNumber);
            builder.append(answer);
        }

        System.out.println(builder);
        br.close();
    }
}
