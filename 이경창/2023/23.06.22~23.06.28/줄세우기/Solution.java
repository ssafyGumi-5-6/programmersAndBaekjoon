package 줄세우기;

import java.io.*;
import java.util.*;

public class Solution {

    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int tk = 1; tk <= T; tk++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int testCase = Integer.parseInt(st.nextToken());
            int size = st.countTokens();
            int[] arr = new int[st.countTokens() + 10];

            int idx = 0;
            while (st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) answer += 1;
                }
            }

            sb.append(testCase + " " + answer + "\n");
        }

        System.out.println(sb.toString());


        br.close();
    }
}
