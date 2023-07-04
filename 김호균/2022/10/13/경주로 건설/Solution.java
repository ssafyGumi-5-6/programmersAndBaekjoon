class Solution {
    int answer;
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        // dfs로 모든 경로 최소 비용 구하자
        // 일반적인 dfs는 시간초과 발생하기 때문에 비용을 지속적으로 누적해야 한다.
        // 방향에 따라 비용은 달라지고 
        int[][][] totalCost = new int[4][board.length][board.length];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < board.length; j++) {
                for(int k = 0; k < board.length; k++) {
                    totalCost[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        totalCost[0][0][0] = 0;
        totalCost[1][0][0] = 0;
        totalCost[2][0][0] = 0;
        totalCost[3][0][0] = 0;
        dfs(board, totalCost, 0 ,0, 0);
        dfs(board, totalCost, 0 ,0, 3);
        return answer;
    }
    
    private void dfs(int[][] board, int[][][] totalCost, int x, int y, int currentDir) {
        if(x == board.length - 1 && y == board.length - 1) {
            answer = Math.min(answer, totalCost[currentDir][y][x]);
            return;
        }
        board[y][x] = 1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(ny < 0 || ny >= board.length || nx < 0 || nx >= board.length || board[ny][nx] == 1) continue;
            
            if(currentDir == d) {
            	if(totalCost[currentDir][y][x] + 100 > totalCost[d][ny][nx]) continue;
                totalCost[d][ny][nx] += 100;
                dfs(board, totalCost, nx, ny, d);
            } else {
            	if(totalCost[currentDir][y][x] + 600  > totalCost[d][ny][nx]) continue;
                totalCost[d][ny][nx] += 600;
                dfs(board, totalCost, nx, ny, d);
            }
            board[ny][nx] = 0;
        }
    }
}