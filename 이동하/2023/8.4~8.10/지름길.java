import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Vertex {
    int node;
    int cost;

    Vertex(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int [] cost = new int [D+1];
        for (int i = 0; i <= D; i++) {
            cost[i] = i;
        }

        int [] [] data = new int [N] [3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            data[i][0] = a;
            data[i][1] = b;
            data[i][2] = c;
        }
        Arrays.sort(data, (o1, o2) -> o1[1] - o2[1]);
//        System.out.println(Arrays.toString(cost));
        for (int i = 0; i < N; i++) {
            if (data[i][1] > D) break;
            cost[data[i][1]] = Math.min(cost[data[i][1]], cost[data[i][0]] + data[i][2]);
            for (int j = data[i][1]+1; j <= D; j++) {
                cost[j] = Math.min(cost[j], cost[j-1] + 1);
            }
//            System.out.println(Arrays.toString(cost));
        }
        System.out.println(cost[D]);
    }
}
