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

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> m = new HashMap<>();
        for (int i = 0; i < N; i++) {
            m.put(br.readLine(), true);
        }

        int answer = N;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if (m.get(s) != null && m.get(s) == true) {
                    answer--;
                    m.put(s, false);
                }
            }
            sb.append(answer+"\n");
        }

        System.out.println(sb);
    }
}