package y2023.s0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Backjoon_2304_창고다각형 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        // List<Pillar> list = new ArrayList<Pillar>();
        Queue<Pillar> pq = new PriorityQueue<Pillar>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            pq.add(new Pillar(l, h));
        }
        Pillar toppestPillar = pq.poll();

        Queue<Pillar> leftPillars = new ArrayDeque<Pillar>();
        Queue<Pillar> rightPillars = new ArrayDeque<Pillar>();
        int startL = toppestPillar.L;
        answer = toppestPillar.H;
        int leftEnd = startL;
        int rightEnd = startL;
        while (!pq.isEmpty()) {
            Pillar cur = pq.poll();
            boolean isLeft = cur.L < startL ? true : false;
            if (cur.L > leftEnd && cur.L < rightEnd) {
                continue;
            }
            if (isLeft) {
                leftEnd = cur.L;
                leftPillars.add(cur);
            } else {
                rightEnd = cur.L;
                rightPillars.add(cur);
            }
        }
        leftEnd = startL;
        rightEnd = startL;
        while (!leftPillars.isEmpty()) {
            Pillar p = leftPillars.poll();
            int w = leftEnd - p.L;
            leftEnd = p.L;
            int h = p.H;
            answer += w * h;
        }
        while (!rightPillars.isEmpty()) {
            Pillar p = rightPillars.poll();
            int w = p.L - rightEnd;
            rightEnd = p.L;
            int h = p.H;
            answer += w * h;
        }
        System.out.println(answer);
    }
}

class Pillar implements Comparable<Pillar> {
    int L;
    int H;

    Pillar(int L, int H) {
        this.L = L;
        this.H = H;
    }
    @Override
    public int compareTo(Pillar o) {
        return o.H - this.H; // 내림차순
    }
}
