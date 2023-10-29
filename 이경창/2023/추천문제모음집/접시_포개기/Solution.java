package 접시_포개기;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        arr = new int[N];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());

            pq.add(arr[i]);
        }

        int result = 0;
        while(pq.size() > 0){
            int firstData = pq.poll();

            if(pq.size() == 0){
                result = firstData;
                break;
            }

            int secondData = pq.poll();

            if(firstData == secondData){
                pq.add(secondData * 2);
            }else{
                // 다른 경우 2번째것만 삽입
                pq.add(secondData);
            }
        }

        System.out.println(result);
        reader.close();
    }
}
