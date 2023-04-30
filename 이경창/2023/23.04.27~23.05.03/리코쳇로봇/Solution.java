package 리코쳇로봇;

import java.util.*;

class Node {
    int x, y;
    int locCnt;

    Node(int x, int y, int locCnt) {
        this.x = x;
        this.y = y;
        this.locCnt = locCnt;
    }
}

public class Solution {

    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;
    String[] board;
    int startX, startY;
    int arriveX, arriveY;
    int row, col;
    int answer;


    public void bfs() {

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(startX, startY, 0));

        while (queue.size() > 0) {
            Node n = queue.poll();

            if (n.x == arriveX && n.y == arriveY) {
                answer = Math.min(answer, n.locCnt);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = n.x;
                int nextY = n.y;


                // 벽이거나 장애물이 보일 때까지 직진
                while (true) {
                    nextX += direction[i][0];
                    nextY += direction[i][1];

                    if (nextX < 0 || nextY < 0 || nextX == row || nextY == col) {
                        nextX -= direction[i][0];
                        nextY -= direction[i][1];
                        break;
                    }

                    if (board[nextX].charAt(nextY) == 'D') {
                        nextX -= direction[i][0];
                        nextY -= direction[i][1];
                        break;
                    }

                }


                if (visited[nextX][nextY]) continue;
                else {
                    visited[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY, n.locCnt + 1));
                }
            }
        }

    }

    public int solution(String[] _board) {

        answer = Integer.MAX_VALUE;
        board = _board;

        visited = new boolean[board.length][board[0].length()];
        row = board.length;
        col = board[0].length();


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char curC = board[i].charAt(j);
                if (curC == 'G') {
                    arriveX = i;
                    arriveY = j;
                } else if (curC == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs();

        int _answer = answer;

        if (_answer == Integer.MAX_VALUE) return -1;
        else return _answer;
    }
}