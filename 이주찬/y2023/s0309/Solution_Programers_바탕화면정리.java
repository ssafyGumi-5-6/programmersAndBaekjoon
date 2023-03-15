package y2023.s0309;

public class Solution_Programers_바탕화면정리 {
    
    static class Solution {
        public int[] solution(String[] wallpaper) {
            int sy = 52;
            int sx = 52;
            int ey = 0;
            int ex = 0;
            int w = wallpaper[0].length();
            int h = wallpaper.length;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (wallpaper[i].charAt(j) == '#') {
                        sy = Math.min(sy, i);
                        sx = Math.min(sx, j);
                        ey = Math.max(ey, i + 1);
                        ex = Math.max(ex, j + 1);
                    }
                }
            }
            return new int[]{sy, sx, ey, ex};
        }
    }
}
