package y2023.s0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_Backjun_22233_가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> keywords = new HashSet<>();

        for (int i = 0; i < n; i++) {
            keywords.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String note = br.readLine();
            st = new StringTokenizer(note, ",");
            while (st.hasMoreTokens()) {
                String key = st.nextToken();
                if (keywords.contains(key)) {
                    keywords.remove(key);
                }
            }
            sb.append(keywords.size()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
