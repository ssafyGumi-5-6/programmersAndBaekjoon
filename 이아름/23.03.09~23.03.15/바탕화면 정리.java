class Solution {
    public int[] solution(String[] wallpaper) {
         int N = wallpaper.length;
        int M = wallpaper[0].length();
        char[][] map = new char[N][M];
        int left = 999_999, top = 999_999;  // 시작
        int right = -999_999, bottom = -999_999;  // 끝

        for (int i = 0; i < N; i++) {
            map[i] = wallpaper[i].toCharArray();
        }

        // 세로-> 가로 탐색
        for (int i = 0; i < M; i++) {   // 세로
            for (int j = 0; j < N; j++) {   // 가로
                if (map[j][i] == '#') {
                    left = Math.min(left, i);
                    right = Math.max(right, i + 1);
                }
            }
        }

        // 가로 -> 세로 탐색
        for (int i = 0; i < N; i++) {   // 가로
            for (int j = 0; j < M; j++) {   // 세로
                if (map[i][j] == '#') {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i + 1);
                }
            }
        }
        return new int[]{top, left, bottom, right};
    }
}