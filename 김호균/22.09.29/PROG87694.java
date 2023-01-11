package s0929;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static class Data {
        int x, y;
        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] visited = new int[101][101];
        for(int i = 0, size = rectangle.length; i < size; i++ ) {
            for(int j = rectangle[i][0] * 2; j <= rectangle[i][2] * 2; j++) {
                for(int k = rectangle[i][1] * 2; k <= rectangle[i][3] * 2; k++) {
                    visited[k][j] = 2;
                }
            }
            
            for(int j = rectangle[i][1] * 2; j <= rectangle[i][3] * 2; j++) {
                for(int k = rectangle[i][0] * 2; k <= rectangle[i][2] * 2; k++) {
                    visited[j][k] = 2;
                }
            }
        }
        
        Queue<Data> q = new ArrayDeque<>();
        visited[characterY * 2][characterX * 2] = 1;
        q.offer(new Data(characterX * 2, characterY * 2));
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(--size >= 0) {
                int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
                int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
            
                Data cur = q.poll();
                
                int x = cur.x;
                int y = cur.y;
            
                if(x == itemX * 2 && y == itemY * 2) {
                    q.clear();
                    depth = (depth - 1) / 2;
                    break;
                }
                
                for(int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    
                    if(nx < 1 || nx >= 101 || ny < 1 || ny >= 101 || visited[ny][nx] != 2) continue;
                    
                    boolean flag = true;
                    for(int i = 0; i < rectangle.length; i++ ) {
                        if(rectangle[i][0] * 2 < nx && nx < rectangle[i][2] * 2 && rectangle[i][1] * 2 < ny && ny < rectangle[i][3] * 2) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        visited[ny][nx] = 1;
                        q.offer(new Data(nx, ny));    
                    }
                    
                }    
            }
            depth++;
        }
        
        answer = depth;
        return answer;
    }
}