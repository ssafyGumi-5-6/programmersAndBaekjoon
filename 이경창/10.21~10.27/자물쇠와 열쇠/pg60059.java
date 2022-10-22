class pg60059 {
    static int N, M;
    static int[][] rectan, copyrecTan;
    static int rectanLen;
    static int[][][] recGame;

    // 현재 체크한 자물쇠에 1이 아닌 것이 있다면, 열 수 없다!
    boolean checkRectangle() {
        for (int i = M - 1; i < M - 1 + N; i++) {
            for (int j = M - 1; j < M - 1 + N; j++) {
                if (copyrecTan[i][j] != 1) return false;
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        M = key.length;
        N = lock.length;

        // 자물쇠의 크기를 늘린다.
        rectanLen = 2 * (M - 1) + N;
        rectan = new int[rectanLen][rectanLen];
        copyrecTan = new int[rectanLen][rectanLen];
        recGame = new int[4][M][M];


        // 시작 전 lock 저장
        for (int i = M - 1; i < M - 1 + N; i++) {
            for (int j = M - 1; j < M - 1 + N; j++) {
                rectan[i][j] = lock[i - (M - 1)][j - (M - 1)];
            }
        }

        recGame[0] = key;

        // 90, 180, 270 회전 저장
        for (int i = 1; i < 4; i++) {
            for (int k = 0; k < M; k++) {
                for (int k2 = 0; k2 < M; k2++) {
                    recGame[i][k][k2] = recGame[i - 1][M - k2 - 1][k];
                }
            }
        }

        // 첫 열쇠의 마지막 행열 위치 M-1, M-1부터 2 * (M - 1) + N; 까지 반복문을 돌린다.
        Loop:
        for (int i = M - 1; i < rectanLen; i++) {
            for (int j = M - 1; j < rectanLen; j++) {

                // 회전 : 0, 90, 180, 270
                for (int r = 0; r < 4; r++) {
                    // 결과를 저장할 배열
                    copyrecTan = rectan;

                    // 자물쇠 돌기에 열쇠 돌기를 넣는다.
                    for (int k = 0; k <= M - 1; k++) {
                        for (int k2 = 0; k2 <= M - 1; k2++) {
                            copyrecTan[i - (M - 1) + k][j - (M - 1) + k2] += recGame[r][k][k2];
                        }
                    }

                    // 모두 1인지 검사한다.
                    if (checkRectangle()) {
                        answer = true;
                        break Loop;
                    }

                    // 자물쇠 돌기에 넣었던 열쇠 돌기를 뺀다.
                    for (int k = 0; k <= M - 1; k++) {
                        for (int k2 = 0; k2 <= M - 1; k2++) {
                            copyrecTan[i - (M - 1) + k][j - (M - 1) + k2] -= recGame[r][k][k2];
                        }
                    }
                }
            }
        }

        return answer;
    }
}