package java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10431_줄세우기 {

    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());

        for (int p = 0; p < P; p++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            arr = new int[20];
            count = 0;

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int start = 19;
            while (start > 0) {
                if (arr[start - 1] < arr[start]) {
                    start--;
                }

                int tmp = start;
                while (tmp > 0 && arr[tmp - 1] > arr[tmp]) {
                    swap(tmp - 1, tmp);
                    tmp--;
                    start = 19;
                }
            }

            sb.append(t).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        count++;
    }
}