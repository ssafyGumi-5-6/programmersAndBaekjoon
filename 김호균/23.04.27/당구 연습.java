class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < balls.length; i++) {
            int x = 0;
            int y = 0;
            
            if(balls[i][1] != startY) {
                x = (startX - (2 * m - balls[i][0])) * (startX - (2 * m - balls[i][0]));
                y =(startY - balls[i][1]) * (startY - balls[i][1]);

                answer[i] = Math.min(answer[i], x + y);

                x = (startX + balls[i][0]) * (startX + balls[i][0]);
                y = (startY - balls[i][1]) * (startY - balls[i][1]);

                answer[i] = Math.min(answer[i], x + y);
            } else {
                if(startX < balls[i][0]) {
                    answer[i] = Math.min(answer[i], (startX + balls[i][0]) * (startX + balls[i][0]));
                } else {
                    answer[i] = Math.min(answer[i], (2 * m - startX - balls[i][0]) * (2 * m - startX - balls[i][0]));
                }
            }
            
            if(balls[i][0] != startX) {
                x = (startX - balls[i][0]) * (startX - balls[i][0]);
                y = (startY + balls[i][1]) * (startY + balls[i][1]);

                answer[i] = Math.min(answer[i], x + y);

                x = (startX - balls[i][0]) * (startX - balls[i][0]);
                y = (startY - (2 * n - balls[i][1])) * (startY - (2 * n - balls[i][1]));

                answer[i] = Math.min(answer[i], x + y);    
            } else {
                if(startY < balls[i][1]) {
                    answer[i] = Math.min(answer[i], (startY + balls[i][1]) * (startY + balls[i][1]));
                } else {
                    answer[i] = Math.min(answer[i], (2 * n - startY - balls[i][1]) * (2 * n - startY - balls[i][1]));
                }
            }
            
        }
        
        return answer;
    }
}
