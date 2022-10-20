import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_Bj_16928_뱀과사다리게임 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] pan = new int[100];

        PriorityQueue<Reg> pq = new PriorityQueue<>(new Comparator<Reg>() {

            @Override
            public int compare(Reg o1, Reg o2) {
                if(o1.start > o2.end) {
                    return 1;
                } else if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }else {
                    return o2.end - o1.end;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            pan[s] = e;
            pq.offer(new Reg(s, e));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            pan[s] = e;
        }
        int cnt = 0;
        int x = 0;

        Reg nextReg = !pq.isEmpty() ? pq.poll() : null;
        Loop1: while (x != 99) {
            if (nextReg != null) {
                int goal = nextReg.start;
                System.out.println("goal : " + goal);
                for (int i = x + 1; i <= x + 6; i++) {
                    if (i == goal) {
                        x = pan[goal];
                        nextReg = !pq.isEmpty() ? pq.poll() : null;
                        cnt++;
                        System.out.println("x : " + x);
                        System.out.println("cnt : " + cnt);
                        continue Loop1;
                    }
                }
            }
            for (int i = x + 6; i > x; i--) {
                if (i > 99 || (pan[i] != 0 && pan[i] < i)) {
                    continue;
                }
                x = i;
                break;
            }
            cnt++;
            System.out.println("x : " + x);
            System.out.println("cnt : " + cnt);
        }
        
        System.out.println(cnt);
    }

}

class Reg {
    int start;
    int end;

    Reg(int start, int end) {
        this.start = start;
        this.end = end;
    }
}