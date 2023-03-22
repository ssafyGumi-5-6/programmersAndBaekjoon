/* 
[[1, 1, 1], [1, 1, 1], [1, 1, 1]]	[1, 0]	[1, 2]	5
[[1, 1, 1], [1, 0, 1], [1, 1, 1]]	[1, 0]	[1, 2]	4
[[1, 1, 1, 1, 1]]	[0, 0]	[0, 4]	4
[[1]]	[0, 0]	[0, 0]	0
 */

public class Solution_Programers_사라지는발판 {
    public static void main(String[] args) {
        int[][][] input = {
                {
                        { 1, 1, 1 },
                        { 1, 1, 1 },
                        { 1, 1, 1 }
                },
                {
                        { 1, 1, 1 },
                        { 1, 0, 1 },
                        { 1, 1, 1 }
                },
                {
                        { 1, 1, 1, 1, 1 }
                },
                {
                        { 1 }
                }
        };
        int[][] playerA = {
                { 1, 0 }, { 1, 0 }, { 0, 0 }, { 0, 0 }
        };
        int[][] playerB = {
                { 1, 2 }, { 1, 2 }, { 0, 4 }, { 0, 0 }
        };
        Solution sol = new Solution();
        for (int i = 0; i < playerA.length; i++) {
            int res = sol.solution(input[i], playerA[i], playerB[i]);
            System.out.println(res);
        }
    }
}

class Solution {
    static int[] se = { -1, 0, 1, 0 };
    static int[] ga = { 0, 1, 0, -1 };

    Player RealLooser;

    static int answer = 0;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        RealLooser = null;
        answer = 0;
        int rAnswer = 0;
        int R = board.length;
        int C = board[0].length;
        int sumPan = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sumPan += board[i][j];
            }
        }
        Player b = new Player(bloc[0], bloc[1], true);
        Player a = new Player(aloc[0], aloc[1], false);
        while (RealLooser == null) {
            move(a, b, board, R, C);
        }
        rAnswer = answer;
        RealLooser = null;
        a.winner = true;
        b.winner = false;
        answer = 0;
        while (RealLooser == null) {
            move(a, b, board, R, C);
        }
        if (rAnswer < answer)
            rAnswer = answer;
        return rAnswer;
    }
    
    void move(Player first, Player second, int[][] board, int R, int C) {
        if (board[first.y][first.x] == 0) {
            RealLooser = first;
            return;
        }
        int nextX = -1;
        int nextY = -1;
        int minD = Integer.MAX_VALUE;
        int maxD = -1;
        for (int i = 0; i < 4; i++) {
            int wys = first.y + se[i];
            int wxg = first.x + ga[i];
            if (wys < 0 || wys >= R || wxg < 0 || wxg >= C || board[wys][wxg] == 0)
                continue;
            int nextD = getDistance(wxg, second.x, wys, second.y);
            if (first.winner) {
                if (nextD < minD) {
                    minD = nextD;
                    nextY = wys;
                    nextX = wxg;
                }
            } else {
                if (nextD > maxD) {
                    maxD = nextD;
                    nextY = wys;
                    nextX = wxg;
                }
            }
        }
        // System.out.println("a = nextY : " + nextY + ", nextX : " + nextX);
        if (nextX == -1) {
            RealLooser = first;
            return;
        }
        board[first.y][first.x] = 0;
        first.y = nextY;
        first.x = nextX;
        answer++;
        nextX = -1;
        nextY = -1;
        if (board[second.y][second.x] == 0) {
            RealLooser = second;
            return;
        }
        minD = Integer.MAX_VALUE;
        maxD = -1;
        for (int i = 0; i < 4; i++) {
            int lys = second.y + se[i];
            int lxg = second.x + ga[i];
            if (lys < 0 || lys >= R || lxg < 0 || lxg >= C || board[lys][lxg] == 0)
            continue;
            int nextD = getDistance(lxg, first.x, lys, first.y);
            if (second.winner) {
                if (nextD < minD) {
                    minD = nextD;
                    nextY = lys;
                    nextX = lxg;
                }
            } else {
                if (nextD > maxD) {
                    maxD = nextD;
                    nextY = lys;
                    nextX = lxg;
                }
            }
        }
        // System.out.println("b = nextY : " + nextY + ", nextX : " + nextX);
        if (nextX == -1) {
            RealLooser = second;
            return;
        }
        board[second.y][second.x] = 0;
        second.y = nextY;
        second.x = nextX;
        answer++;
    }

    int getDistance(int ax, int bx, int ay, int by) {
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
}

class Player {
    int y;
    int x;
    boolean winner;
    Player(int y, int x, boolean winner) {
        this.y = y;
        this.x = x;
        this.winner = winner;
    }
}