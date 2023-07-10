import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        // 머리 시작점을 찾는다.
        int[] startPoint = findStartPoint(board);

        // 심장 좌표를 구한다.
        int[] heartPoint = findHeart(board, startPoint[0], startPoint[1]);

        // 각 신체 부위의 좌표를 구한다.
        int[] lengthEachPart = findLength(board, heartPoint[0], heartPoint[1]);

        System.out.println(++heartPoint[0] + " " + ++heartPoint[1]);
        for( int i : lengthEachPart) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    /**
     * 각 신체 부위의 길이를 반환한다.
     *
     * @param board
     * @param heartY
     * @param heartX
     * @return {왼 팔 길이, 오른 팔 길이, 허리 길이, 왼 다리 길이, 오른 다리 길이} 반환한다.
     * 없으면 모든 요소는 0이다.
     */
    private static int[] findLength(char[][] board, int heartY, int heartX) {
        int[] length = new int[5];

        // 왼 팔
        for (int i = (heartX - 1); i >= 0; i--) {
            if (board[heartY][i] != '*') {
                break;
            }
            length[0]++;
        }

        // 오른 팔
        for (int i = (heartX + 1); i < board.length; i++) {
            if (board[heartY][i] != '*') {
                break;
            }
            length[1]++;
        }

        int index = heartY + 1;
        // 허리
        for (int i = index; i < board.length; i++) {
            if (board[i][heartX] != '*') {
                index = i;
                break;
            }
            length[2]++;
        }

        // 왼 다리
        for (int i = index; i < board.length; i++) {
            if (board[i][heartX - 1] != '*') {
                break;
            }
            length[3]++;
        }

        // 오른 다리
        for (int i = index; i < board.length; i++) {
            if (board[i][heartX + 1] != '*') {
                break;
            }
            length[4]++;
        }

        return length;
    }

    /**
     * 심장의 위치를 반환한다.
     *
     * @param board  입력받은 배열
     * @param startY 머리의 시작지점의 Y좌표
     * @param startX 머리의 시작지점의 X좌표
     * @return 배열을 반환한다. {심장 열번호, 심장 행번호} 없으면 {0, 0}을 반환한다.
     */
    private static int[] findHeart(char[][] board, int startY, int startX) {
        for (int i = startY; i < board.length; i++) {
            if (board[i][startX - 1] == '*' && board[i][startX + 1] == '*') {
                return new int[]{i, startX};
            }
        }

        return new int[]{0, 0};
    }

    /**
     * 머리의 시작지점을 찾는다.
     *
     * @param board 입력받은 배열
     * @return 시작 좌표{열, 행}를 반환한다. 좌표를 찾을 수 없으면 {0, 0}을 반환한다.
     */
    private static int[] findStartPoint(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '*') {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{0, 0};
    }

}
