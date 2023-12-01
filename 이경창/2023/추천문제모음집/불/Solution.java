package 불;

import java.io.*;
import java.util.*;

public class Solution {

    private static class Node{
        public final int x;
        public final int y;
        public final int time;

        Node(int x , int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    private static int R, C;
    private static char[][] cArr;
    private static int[][] fireTimeArr;
    private static int[] jiHunArr;
//    private static int[] fireStartArr;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, -1, 0, 1 };
    private static int MAXVALUE = 1000010;

    private static boolean isWithInRange(int row, int col){
        return 0 <= row && 0 <= col && row < R && col < C;
    }

    // 불이 미로에 몇 초에 도착하는지 저장
    private static void bfs1(){
        // 0 : y, 1 : x
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(fireTimeArr[i][j] == 0){
                    queue.add(new Node(j, i, 0));
                    visited[i][j] = true;
                }
            }
        }

        while(queue.size() > 0){
            Node n = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + n.x;
                int ny = dy[i] + n.y;

                if(!isWithInRange(ny, nx)) continue;
                if(cArr[ny][nx] == '#') continue;
                if(visited[ny][nx]) continue;
                if(fireTimeArr[ny][nx] <= n.time + 1) continue;
                visited[ny][nx] = true;
                fireTimeArr[ny][nx] = n.time + 1;
                queue.add(new Node(nx, ny, n.time + 1));
            }
        }
    }

    // 사람 이동
    private static int bfs2(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(jiHunArr[1], jiHunArr[0], 0));
        boolean[][] visited = new boolean[R][C];
        visited[jiHunArr[0]][jiHunArr[1]] = true;
        int result = Integer.MAX_VALUE;

        while(queue.size() > 0){
            Node n = queue.poll();
//            System.out.println("node 꺼낸 값 : " + n.y + " " + n.x + " " + n.time + " " + fireTimeArr[n.y][n.x]);

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + n.x;
                int ny = dy[i] + n.y;

                if(!isWithInRange(ny, nx)){
//                    System.out.println(ny + " " + nx + " " + "result : " + result);
                    result = Math.min(result, n.time + 1);
                    break;
                }

                if(cArr[ny][nx] == '#') continue;
                // 도착시간보다 화염이 먼저 왔다면
                if(fireTimeArr[ny][nx] <= n.time + 1) continue;
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;
//                System.out.println(ny + " " + nx + " " + fireTimeArr[ny][nx] + " " + (n.time + 1));
                queue.add(new Node(nx, ny, n.time + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        cArr = new char[R][C];
        fireTimeArr = new int[R][C];
        jiHunArr = new int[2];

        // 초기값
        for(int i = 0; i < R; i++){
            Arrays.fill(fireTimeArr[i], MAXVALUE);
        }

        for(int i = 0; i < R; i++){
            char[] c = reader.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                cArr[i][j] = c[j];
                if(c[j] == 'J'){
                    jiHunArr[0] = i;
                    jiHunArr[1] = j;
                }else if(c[j] == 'F'){
                    fireTimeArr[i][j] = 0;
                }
            }
        }

        bfs1();
        int answer = bfs2();
        System.out.println((answer == Integer.MAX_VALUE ? "IMPOSSIBLE" : answer));

    }
}
