class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0}; // 시작x, 시작y, 끝x, 끝y
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    if(i < answer[0]) answer[0] = i;
                    if(i > answer[2]) answer[2] = i;
                    
                    if(j < answer[1]) answer[1] = j;
                    if(j > answer[3]) answer[3] = j;
                }
            }
        }
        answer[2]++;
        answer[3]++;
        return answer;
    }
}
