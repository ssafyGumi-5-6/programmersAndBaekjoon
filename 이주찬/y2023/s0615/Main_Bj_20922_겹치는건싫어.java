package y2023.s0615;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Bj_20922_겹치는건싫어 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] kArr = new int[100001];
        int front = 0;
        int end = 0;
        int answer = 0;
        int curMax = 0;
        while (front < arr.length) {
            int head = arr[front];
            kArr[head]++;
            if (kArr[head] > k) {
                while (kArr[head] > k) {
                    kArr[arr[end]]--;
                    end++;
                }
            }
            curMax = front - end + 1;
            answer = Math.max(curMax, answer);
            front++;
        }
        System.out.println(answer);
    }
}
