package y2023.s0316;


public class Solution_Programers_호텔대실 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] input = {{"00:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"},{"18:20","23:59"}};
        System.out.println(sol.solution(input));
}

    static class Solution {
        public int solution(String[][] book_time) {
            int[] pan = new int[24 * 60 + 10];
            int max = 0;
            for (int i = 0; i < book_time.length; i++) {
                String[] startTimeStr = book_time[i][0].split(":");
                String[] endTimeStr = book_time[i][1].split(":");
                int startTimeInt = Integer.parseInt(startTimeStr[0]) * 60 + Integer.parseInt(startTimeStr[1]);
                int endTimeInt = Integer.parseInt(endTimeStr[0]) * 60 + Integer.parseInt(endTimeStr[1]) + 10;
                for (int j = startTimeInt; j < endTimeInt; j++) {
                    pan[j]++;
                    if (max < pan[j]) {
                        max = pan[j];
                    }
                }
            }
            return max;
        }
    }
}
