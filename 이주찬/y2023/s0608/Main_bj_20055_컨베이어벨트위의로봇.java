package y2023.s0608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_20055_컨베이어벨트위의로봇 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 컨베이어 벨트의 반(총 길이는 2N)
        int n = Integer.parseInt(st.nextToken());

        // 내구도 한계점 K
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Belt belt = new Belt(n, k, st);

        int level = 1;

        while (true) {
            // belt.printStatus();

            belt.rotation();
            belt.robotMove();
            belt.putRobot();
            if (belt.check()) {
                break;
            }
            level++;
        }

        System.out.println(level);
    }
    
    static class Belt {
        // 올리는 위치
        int start;
        // 내리는 위치
        int end;
        // 상판 벨트 수
        int n;
        // 2n 구해놓기
        int n2;
        // 각 구간 내구도
        int[] duration;
        // 로봇들
        boolean[] robots;

        // 내구도 한계 K
        int k;
        // 내구도가 다한 벨트 개수
        int exit = 0;

        public Belt(int n, int k, StringTokenizer st) {
            this.start = 0;
            this.end = n - 1;
            this.n = n;
            this.k = k;
            this.n2 = n * 2;
            duration = new int[n2];
            robots = new boolean[n2];

            for (int i = 0; i < n2; i++) {
                int num = Integer.parseInt(st.nextToken());
                duration[i] = num;
            }

        }

        //한칸 회전
        public void rotation() {
            start--;
            end--;
            if (start < 0) {
                start = n2 - 1;
            }
            if (end < 0) {
                end = n2 - 1;
            }
        }

        // 로봇이 이동
        public void robotMove() {
            int cur = end;
            if (robots[cur]) {
                robots[cur] = false;
            }
            while (true) {
                int next = cur + 1;
                int prev = cur - 1;
                if (next >= n2) {
                    next = 0;
                }
                if (prev < 0) {
                    prev = n2 - 1;
                }
                if (robots[cur] && !robots[next] && duration[next] > 0) {
                    robots[cur] = false;
                    robots[next] = true;
                    durationMinus(next);
                    if (next == end) {
                        robots[next] = false;
                    }
                }
                if (cur == start)
                    break;
                cur = prev;
            }
        }
        
        public void putRobot() {
            if (duration[start] > 0) {
                robots[start] = true;
                durationMinus(start);
            }
        }

        public boolean check() {
            if (exit >= k) {
                return true;
            } else
                return false;
        }
        
        void durationMinus(int idx) {
            duration[idx]--;
            if (duration[idx] == 0) {
                exit++;
            }
        }

        // public void printStatus() {
        //     for (int i = 0; i < duration.length; i++) {
        //         System.out.print(duration[i] + " ");
        //     }
        //     System.out.println();
        // }

    }
}
