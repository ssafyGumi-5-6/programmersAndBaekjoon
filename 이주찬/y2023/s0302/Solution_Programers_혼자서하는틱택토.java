package y2023.s0302;

public class Solution_Programers_혼자서하는틱택토 {
    public static void main(String[] args) {
        /* ["O.X", ".O.", "..X"]	1
        ["OOO", "...", "XXX"]	0
        ["...", ".X.", "..."]	0
        ["...", "...", "..."]	1 */
        Solution sol = new Solution();
        String[][] input = {
                // {"O.X", ".O.", "..X"},
                // {"OOO", "...", "XXX"},
                // {"...", ".X.", "..."},
                // { "...", "...", "..." },
                // { "O..", "O..", "O.." },
                // {"OXO", "XOX", "OXO"},
                // {"OOX", "XXO", "OOX"},
                // {"XXX", ".OO", "O.."},
                // {"OX.", ".O.", ".XO"},
                // {"...", "...", ".O."},
                // {"X.X", "X.O", "O.O"},
                // {"XO.", "OXO", "XOX"},
                // {"OOO", "XOX", "XXO"},
                {"OOO", "XOX", "X.X"},
                {"XXX", "OO.", "OO."},
                {".X.", "...", "..."},
                {".X.", "X..", ".O."},
                {"XOX", "OXO", "XOX"},
                {"XXX", "XOO", "OOO"},
                {"OOX", "OXO", "XOO"},
                {"OOX", "OXO", "XOX"},
                {".OX", "OXO", "XO."},
                {"OOO", "XX.", "X.."},
            };
        for (int i = 0; i < input.length; i++) {
            System.out.println(sol.solution(input[i]));
        }
    }

    static class Solution {
        int[] dx = { 1, 1, 0, -1 };
        int[] dy = { 0, 1, 1, 1 };
        public int solution(String[] board) {
            int answer = -1;
            char[][] pan = new char[3][3];
            int countX = 0;
            int countO = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char tmp = board[i].charAt(j);
                    pan[i][j] = tmp;
                    if (tmp == 'X') {
                        countX++;
                    } else if (tmp == 'O') {
                        countO++;
                    }
                }
            }
            if (!(countX == countO || countO - countX == 1 )) {
                return 0;
            }

            int winCountO = 0;
            int winCountX = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    char winChar = isWin(j, pan, 0, i);
                    if (winChar == 'O')
                        winCountO++;
                    else if (winChar == 'X')
                        winCountX++;

                    if (i > 0) {
                        winChar = isWin(j, pan, i, 0);
                        if (winChar == 'O')
                            winCountO++;
                        else if (winChar == 'X')
                            winCountX++;
                    }
                }
            }
            if ((winCountX != 0 && winCountO != 0) || (winCountO == 1 && countO <= countX) || (winCountX == 1 && countO > countX)) {
                return 0;
            }
            return 1;
        }

        public char isWin(int direction, char[][] pan, int curY, int curX) {
            char curChar = pan[curY][curX];
            if (curChar == '.')
                return '.';
            int count = 1;
            while (true) {
                curY += dy[direction];
                curX += dx[direction];
                if (curY < 0 || curY > 2 || curX < 0 || curX > 2) {
                    break;
                }
                if (pan[curY][curX] == curChar) {
                    count++;
                    if (count == 3)
                        return curChar;
                } else
                    break;
            }
            return '.';
        }
    }
}
