import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    static class Position {
        private int y;
        private int x;

        Position(int y, int x) {
            this.x = x;
            this.y = y;
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int wide = sc.nextInt();
        sc.nextLine();

        int[][] originalBoard = new int[height][wide]; // 입력받은 지도
        int[][] finalBoard = new int[height][wide]; // 최종 결과를 저장할 배열
        
        int startY = 0;
        int startX = 0;

        for(int i = 0; i < height; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

            for (int j = 0; st.hasMoreTokens(); j++) {
                originalBoard[i][j] = Integer.parseInt(st.nextToken());
                if(originalBoard[i][j] == 2) { // 값이 2이면 시작지점이다.
                    startY = i;
                    startX = j;
                }
            }
        }

        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(startY, startX));
        int depth = 0;
        boolean[][] visited = new boolean[height][wide];
        visited[startY][startX] = true;

        while(!queue.isEmpty()) { // depth를 계산하는 bfs
            int size = queue.size();

            while(--size >= 0) {
                Position cur = queue.poll();
                int y = cur.y;
                int x = cur.x;

                finalBoard[y][x] = depth;

                int[] dx = {1, 0, -1, 0};
                int[] dy = {0, 1, 0, -1};

                for(int d = 0; d < dx.length; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if(
                        ny < 0 || nx < 0 
                        || ny >= height || nx >= wide 
                        || originalBoard[ny][nx] == 0 || visited[ny][nx]
                      ) {
                        continue;
                    }
                    
                    visited[ny][nx] = true;
                    queue.add(new Position(ny, nx));
                }
            }

            depth++;
        }

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < wide; j++) {
                /* 
                 * 결과값은 0이지만 지도의 값은 1이면 도달 못 했다는 뜻이므로
                 * 결과값을 -1로 변경한다.
                 */
                if(finalBoard[i][j] == 0 && originalBoard[i][j] == 1) {
                    finalBoard[i][j] = -1;
                }
                System.out.print(finalBoard[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
