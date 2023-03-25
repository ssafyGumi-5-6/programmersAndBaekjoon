package 바탕화면정리;

class Solution {

    // 가장 작은 행 열 인덱스를 구한다.
    int minX, minY;
    int maxX, maxY;

    public int[] solution(String[] wallpaper) {
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        maxY = Integer.MIN_VALUE;

        for(int wallpaperIdx = 0; wallpaperIdx < wallpaper.length; wallpaperIdx++){
            String wall = wallpaper[wallpaperIdx];
            for(int inWallPaperIdx = 0; inWallPaperIdx < wall.length(); inWallPaperIdx++){
                if(wall.charAt(inWallPaperIdx) == '#'){
                    minX = Math.min(wallpaperIdx, minX);
                    minY = Math.min(inWallPaperIdx, minY);
                    maxX = Math.max(maxX, wallpaperIdx);
                    maxY = Math.max(maxY, inWallPaperIdx);
                }
            }
        }

        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }
}