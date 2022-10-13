public class Solution_Programers_아이템줍기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][][] rectangle = {
                { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } },
                { { 1, 1, 8, 4 }, { 2, 2, 4, 9 }, { 3, 6, 9, 8 }, { 6, 3, 7, 7 } },
                { { 1, 1, 5, 7 } },
                { { 2, 1, 7, 5 }, { 6, 4, 10, 10 } },
                { { 2, 2, 5, 5 }, { 1, 3, 6, 4 }, { 3, 1, 4, 6 } }
        };
        int[] characterX = { 1, 9, 1, 3, 1 };
        int[] characterY = { 3, 7, 1, 1, 4 };
        int[] itemX = { 7, 6, 4, 7, 6 };
        int[] itemY = { 8, 1, 7, 10, 3 };
        for (int i = 0; i < itemX.length; i++) {
            System.out.println(sol.solution(rectangle[i], characterX[i], characterY[i], itemX[i], itemY[i]));
        }
    }

    static class Solution {
        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int answer = Integer.MAX_VALUE;

            return answer;
        }
    }
}