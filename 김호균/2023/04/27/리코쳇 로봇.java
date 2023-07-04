import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    
    public int solution(String[] board) {
        int answer = -1;
        
        for(int i = 0; i < board.length; i++) {
            int j = board[i].indexOf("R");
            if(j != -1) {
                return bfs(board, i, j); // 시작 위치 찾으면 bfs 실행
            }
        }
        
        // 시작 표시가 없으면 -1 return
        return answer;
    }
    
    static class Position {
        int y;
        int x;
        
        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    private int bfs(String[] board, int y, int x) {
        Queue<Position> nextPositionQueue = new ArrayDeque<>();
        nextPositionQueue.add(new Position(y, x));
        
        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[y][x] = true;
        
        int shortestDistance = 0;
        
        while(!nextPositionQueue.isEmpty()) {
            
            int size = nextPositionQueue.size();
            
            while(--size >= 0) {
                Position current = nextPositionQueue.poll();
            
                if(board[current.y].charAt(current.x) == 'G') {
                    return shortestDistance;
                }
            
                int[] dx = {1, -1, 0, 0};
                int[] dy = {0, 0, 1, -1};
                
                for(int d = 0; d < 4; d++) {
                    
                    int ny = current.y;
                    int nx = current.x;
                    
                    // ny, nx가 범위를 벗어나거나 D일 때까지 ny, nx 증가
                    while((ny < board.length && nx < board[0].length() && ny >= 0 && nx >= 0) && board[ny].charAt(nx) != 'D' ) {
                        ny += dy[d];
                        nx += dx[d];
                    }
                    
                    // 범위를 벗어나거나 D라는 뜻이므로 한 번 감소
                    ny -= dy[d];
                    nx -= dx[d];
                    
                    // 방문 안 했으면 다음 위치에 저장
                    if(!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        nextPositionQueue.add(new Position(ny, nx));    
                    }
                    
                }
            }
            
            shortestDistance++;
        }
        
        return -1;
    }
    
}
