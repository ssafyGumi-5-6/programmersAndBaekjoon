import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long [] distance = new long [N-1];
        for (int i = 0; i < N-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }
        long [] cost = new long [N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        long MAX_COST = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            if (MAX_COST > cost[i]) {
                MAX_COST = cost[i];
            }
            answer += MAX_COST * distance[i];
        }
        System.out.println(answer);
    }
}
