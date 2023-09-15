import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N + 1]; // dp[N + 1]은 퇴사한 날 => 수익 0원
        for(int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 퇴사 전날부터 최대비용을 계산한다.
        for(int i = N - 1; i >= 0; --i) {
            int availableDayToConsult = i + T[i];
            // 현재 예약한 상담을 진행할 수 없으면 다음날 수익을 가져온다.
            if(availableDayToConsult > N) {
                dp[i] = dp[i + 1];
            }
            // 현재 예약한 상담을 진행할 수 있으면,
            // 가장 빠른 다음 상담의 수익과 지금 진행한 상담의 수익의 합을
            // 내일 수익과 비교하여 가장 큰 값을 넣는다.
            /* -> 오늘 상담을 하면 내일 상담을 못할 가능성도 있기 때문에 둘을 비교해 더 큰 수익을 남길 수 있는
                  상담을 남긴다. */
            else {
                dp[i] = Math.max(dp[i + 1], dp[availableDayToConsult] + P[i]);
            }
        }

        System.out.println(dp[0]);

        br.close();
    }
}
