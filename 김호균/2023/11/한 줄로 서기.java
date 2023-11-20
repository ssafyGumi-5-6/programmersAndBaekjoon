import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; ++i) {
            int count = Integer.parseInt(st.nextToken());
            // 0은 나보다 큰 수가 올자리 내 앞에 0의 갯수가 count가 되게 위치 조정
            int j;
            for(j = 0; j < N; ++j) {
                if(line[j] == 0) {
                    --count;
                }

                if(count == -1) {
                    break;
                }
            }

            line[j] = i;
        }

        for(int i = 0; i < N; ++i) {
            System.out.print(line[i] + " ");
        }

        br.close();
    }
}
