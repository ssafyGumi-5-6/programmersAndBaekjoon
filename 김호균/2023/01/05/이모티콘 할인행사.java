class Solution {
    int[] answer; // 정답
    int[] discountRate; // 각 이모티콘 할인율
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2]; // 0: 가입자 수, 1: 비용
        discountRate = new int[emoticons.length];
        subset(users, emoticons, emoticons.length - 1);
        return answer;
    }
    
    /*
     * 이모티콘 할인율로 만들 수 있는 모든 부분집합을 구하고
     * 사용자 별로 이모티콘 구매와 플러스 가입여부를 구한다.
     */
    public void subset(int[][] users, int[] emoticons, int index) {
        
        if(index == -1) { //모든 이모티콘 할인율이 결정되면 진입
            int subscriber = 0;
            int revenue = 0;
            /*
             * 모든 사용자를 대상으로 이모티콘 구매 비용과 구독 여부를 확인하고
             * 결과를 subscriber와 revenue 변수에 저장한다.
             */
            for(int i = 0; i < users.length; i++) {
                int cost = 0;
                for(int j = 0; j < emoticons.length; j++) {
                    if(users[i][0] <= discountRate[j]) {
                        cost += emoticons[j] - (emoticons[j] / 100 * discountRate[j]);
                    }
                    
                    if(cost >= users[i][1]) {
                        cost = 0;
                        subscriber++;
                        break;
                    }
                }
                revenue += cost;
            }
            
            // 구독자와 수입을 answer 배열과 비교해 답에 맞는 값을 저장한다.
            if(subscriber > answer[0]) { 
                answer[0] = subscriber;
                answer[1] = revenue;
            } else if(subscriber == answer[0] && answer[1] < revenue) {
                answer[0] = subscriber;
                answer[1] = revenue;
            }
            return;
        }
        
        /*
         * index에 해당하는 이모티콘 할인율을 결정하고 다음 이모티콘으로 넘어간다.
         * 모든 이모티콘 할인율이 결정되고 사용자 확인까지 끝나면
         * 이모티콘 할인율을 변경하고 다음 이모티콘으로 넘어간다.
         */
        discountRate[index] = 10;
        subset(users, emoticons, index - 1);
        
        discountRate[index] = 20;
        subset(users, emoticons, index - 1);
        
        discountRate[index] = 30;
        subset(users, emoticons, index - 1);
        
        discountRate[index] = 40;
        subset(users, emoticons, index - 1);
    }
}