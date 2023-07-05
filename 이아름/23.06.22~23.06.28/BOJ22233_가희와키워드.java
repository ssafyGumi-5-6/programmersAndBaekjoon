package java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ22233_가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        boolean[] visit = new boolean[N];
        int ans = N;

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine(), ",");

            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                if (map.containsKey(str)) {
                    int index = map.get(str);
                    if (!visit[index]) {
                        ans--;
                        visit[index] = true;
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}