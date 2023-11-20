public class Main {
    private int[][] room;
    private int r;
    private int c;
    private int d;
    private final int[] dr = {-1, 0, 1, 0};
    private final int[] dc = {0, 1, 0, -1};

    public static void main (String[] args) throws IOException {
        Main solution = new Main();
        solution.init();
        solution.print(solution.solve());
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; ++j) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

				br.close();
    }

    private int solve() {
        int count = 0;

        while(room[r][c] != 1) {
            // 현재 칸이 청소가 안 됐으면 청소 처리
            if(room[r][c] == 0) {
                room[r][c] = 2;
                ++count;
            }
            
            boolean isClean = false;
            for(int i = 0; i < 4; ++i) {
                turnDirection();
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                // 회전 후 앞 칸이 청소가 안 됐으면 전진
                if(room[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    isClean = false;
                    break;
                }

                isClean = true;
            }
            // 360도 도는 동안 청소 안 된 칸이 없으면 후진
            if(isClean) {
                r -= dr[d];
                c -= dc[d];
            }
        }
        
        return count;
    }

    private void turnDirection() {
        d = (d + 3) % 4;
    }

    private void print(int answer) {
        System.out.println(answer);
    }
}
