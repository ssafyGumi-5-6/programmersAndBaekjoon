package 더하기1234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    private static int T;
    private static int answer;
    private static int MAX_NUMBER = 10010;

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        arr = new int[MAX_NUMBER + 1][4];

        for(int i = 1; i <= 3; i++){
            for(int j = 1; j<=i; j++){
                arr[i][j] = 1;
            }
        }

        for(int i = 4; i <= MAX_NUMBER; i++){
            arr[i][1] = arr[i - 1][1];
            arr[i][2] = arr[i - 2][1] + arr[i - 2][2];
            arr[i][3] = arr[i - 3][1] + arr[i - 3][2] + arr[i - 3][3];
        }

        for(int tk = 1; tk <= T; tk++){
            int n = Integer.parseInt(br.readLine());
            builder.append(arr[n][1] + arr[n][2] + arr[n][3]).append("\n");
        }

        System.out.print(builder);
        br.close();
    }
}
