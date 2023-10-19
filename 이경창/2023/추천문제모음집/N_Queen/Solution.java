package N_Queen;

import java.io.*;

public class Solution {
    private static int N;
    private static int result;
    private static int[] arr;
    private static boolean beforeCheckData(int curRow){
        // 행 번호 차이, 열 번호 차이가 같다면 같은 대각선
        // 저장되어 있는 Map에서 확인
        for(int row = 0; row< curRow; row++){
            if(arr[row] == arr[curRow] || curRow - row == Math.abs(arr[row] - arr[curRow])) return false;
        }
        return true;
    }
    private static void backtracking(int row){
        if(row == N){
            result++;
            return;
        }

        for(int col = 0; col < N; col++){
            arr[row] = col;
            if(beforeCheckData(row)){
                backtracking(row + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        arr = new int[N];

        backtracking(0);
        System.out.println(result);
    }
}
