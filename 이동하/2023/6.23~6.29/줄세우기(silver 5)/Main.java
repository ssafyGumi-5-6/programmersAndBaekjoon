import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기위한 변수를 선언해요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < P; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());

            int [] data = new int [20];
            for (int i = 0; i < 20; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (data[j] > data[i]) cnt++;
                }
            }

            sb.append(T + " " + cnt + "\n");
        }
        System.out.println(sb);
    }
}