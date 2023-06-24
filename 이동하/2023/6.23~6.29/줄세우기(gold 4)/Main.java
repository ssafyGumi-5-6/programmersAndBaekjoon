import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] [] data = new int [2] [N];

        for (int i = 0; i < N; i++) {
            data[0][i] = Integer.parseInt(br.readLine());
            int max_cnt = 0;
            for (int j = 0; j < i; j++) {
//                System.out.println(data[0][i] + " " + data[0][j]);
                if (data[0][i] > data[0][j] && max_cnt < data[1][j]) {
                    max_cnt = data[1][j];
                }
            }
            data[1][i] = max_cnt + 1;
//            System.out.println(Arrays.toString(data[0]));
//            System.out.println(Arrays.toString(data[1]));
//            System.out.println();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, data[1][i]);
        }
        System.out.println(N - answer);
    }
}
