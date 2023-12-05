import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String ticTacToe = br.readLine();
            if(ticTacToe.equals("end")) {
                break;
            }

            int xCount = 0;
            int oCount = 0;
            char[][] board = new char[3][3];
            // O, X 개수를 세고 틱택토판을 만든다.
            for (int i = 0; i < ticTacToe.length(); ++i) {
                if (ticTacToe.charAt(i) == 'X') {
                    ++xCount;
                } else if (ticTacToe.charAt(i) == 'O') {
                    ++oCount;
                }

                board[i / 3][i % 3] = ticTacToe.charAt(i);
            }

            // 개수에 이상이 있으면 invalid 처리하고 다음으로 넘어간다.
            if (xCount - oCount >= 2 || oCount - xCount >= 1) {
                sb.append("invalid\n");
                continue;
            }

            int xBingo = 0;
            int oBingo = 0;
            // 행, 렬이 빙고인지 빙고라면 o인지 x인지 확인한다.
            for (int i = 0; i < 3; ++i) {
                char startRow = board[i][0];
                char startColumn = board[0][i];
                boolean isBingoRow = true;
                boolean isBingoColumn = true;

                for (int j = 1; j < 3; ++j) {
                    if (board[i][j] != startRow) {
                        isBingoRow = false;
                    }

                    if (board[j][i] != startColumn) {
                        isBingoColumn = false;
                    }
                }

                if (isBingoRow) {
                    if (startRow == 'X') {
                        ++xBingo;
                    } else if (startRow == 'O') {
                        ++oBingo;
                    }
                }

                if (isBingoColumn) {
                    if (startColumn == 'X') {
                        ++xBingo;
                    } else if (startColumn == 'O') {
                        ++oBingo;
                    }
                }
            }

            char startRightDiagonal = board[0][0];
            char startLeftDiagonal = board[0][2];
            boolean isRightBingo = true;
            boolean isLeftBingo = true;
            // 대각선 빙고 여부 확인
            for(int i = 1; i < 3; ++i) {
                if (startRightDiagonal != board[i][i]) {
                    isRightBingo = false;
                }

                if (startLeftDiagonal != board[i][2 - i]) {
                    isLeftBingo = false;
                }
            }

            if (isRightBingo) {
                if (startRightDiagonal == 'X') {
                    ++xBingo;
                } else if (startRightDiagonal == 'O') {
                    ++oBingo;
                }
            }

            if (isLeftBingo) {
                if (startLeftDiagonal == 'X') {
                    ++xBingo;
                } else if (startLeftDiagonal == 'O') {
                    ++oBingo;
                }
            }

            // 빙고가 없으면서 X, O 개수에 문제있는 경우
            // X 빙고 면서 O도 빙고이거나 X와 O의 개수가 같은 경우
            // O 빙고 이면서 X와 O의 개수가 다른 경우 invalid 처리한다.
            if ((xBingo == 0 && oBingo == 0 && xCount < 5 && oCount < 4)
                || (xBingo >= 1 && (xBingo <= oBingo || xCount == oCount))
                || (oBingo == 1 && xCount != oCount)) {
                sb.append("invalid\n");
                continue;
            }

            // 그 외 모든 상황을 valid 처리한다.
            sb.append("valid\n");
        }
        br.close();

        System.out.println(sb);
    }
}
