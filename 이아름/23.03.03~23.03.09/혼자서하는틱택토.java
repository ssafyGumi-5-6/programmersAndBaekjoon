
public class 혼자서하는틱택토 {
    public static void main(String[] args) {
        String[] board = {"OX.", "OXO", ".XO"};
        int res = solution(board);
        System.out.println(res);
    }
    static int[] dx = {-1, 0, 1, 1};    // 오른쪽위, 오른쪽, 오른쪽아래, 아래
    static int[] dy = {1, 1, 1, 0};
    static boolean winX = false;
    static boolean winO = false;

    public static int solution(String[] board) {
        char[][] map = new char[3][3];
        int countO = 0;
        int countX = 0;

        // 개수 세기
        for (int i = 0; i < board.length; i++) {
            char[] c = board[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                map[i][j] = c[j];
                switch (c[j]) {
                    case 'O' -> {
                        countO++;
                    }
                    case 'X' -> {
                        countX++;
                    }
                }
            }
        }

        // X가 더 많은 경우
        if (countO < countX)
            return 0;
        // X와 O의 차가 1이상인 경우
        if (Math.abs(countO - countX) > 1)
            return 0;

        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                if (map[i][j] != '.')
                    for (int direct = 0; direct < dx.length; direct++)
                        if (map[i][j] == 'X')
                            checkFinish(map, direct, i, j, 1, 0);
                        else if (map[i][j] == 'O')
                            checkFinish(map, direct, i, j, 0, 1);

        // 둘 다 이기는 경우
        if (winX && winO) {
            return 0;
        } else {
            // 둘 다 아직 이기기 전
            if (!winX && !winO) {
                return 1;
                // O가 이기는데 X 개수가 O와 같거나 더 많은 경우
            } else if (winO && countO <= countX ||
                // X가 이기는데 O 개수가 더 많은 경우
                    winX && countO > countX)
                return 0;
            else
                return 1;
        }
    }
    private static void checkFinish(char[][] map, int direct, int i, int j, int x, int o) {
        if (o == 3) {
            winO = true;
            return;
        }
        if (x == 3) {
            winX = true;
            return;
        }
        int ii = i + dx[direct];
        int jj = j + dy[direct];
        if (ii >= 3 || jj >= 3 || ii < 0 || jj < 0) return;
        if (map[ii][jj] == 'X')
            checkFinish(map, direct, ii, jj, x + 1, o);
        else if (map[ii][jj] == 'O')
            checkFinish(map, direct, ii, jj, x, o + 1);
    }
}
