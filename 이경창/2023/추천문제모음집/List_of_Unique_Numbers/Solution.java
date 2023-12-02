package List_of_Unique_Numbers;

import java.util.*;
import java.io.*;

public class Solution {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

//        int answer = 0;
//        Queue<Integer> queue = new LinkedList<>();
//
//        for(int i = 0; i < N; i++){
//            while(queue.contains(arr[i])) queue.poll();
//            queue.add(arr[i]);
//            int queueSize = queue.size();
//            answer += queueSize;
//        }

        int left = 0;
        int right = 0;
        long answer = 0;
        boolean[] visited = new boolean[100010];

        while(left < N){
            if(right < N && !visited[arr[right]]){
                visited[arr[right]] = true;
                right += 1;
            }else {
                // right은 한 칸 더 간 상태에서 결과에 저장
                answer += (right - left);
//                System.out.println(right + " " + left + " " + answer);
                visited[arr[left]] = false;
                left += 1;

            }
        }

        System.out.println(answer);

        reader.close();
    }
}
