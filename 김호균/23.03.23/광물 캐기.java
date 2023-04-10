class Solution {
    int answer;
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] == 0) continue;
            dfs(i, picks, minerals, 0, 0);
            picks[i]++;
        }
        
        return answer;
    }
    
    private void dfs(int pickaxes, int[] picks, String[] minerals, int count, int tiredness) {
        // 사용한 곡괭이 제거
        picks[pickaxes]--;
        
        int dPoint = 1;
        int iPoint = 1;
        int sPoint = 1;
        
        // 곡괭이 별로 피로도 설정
        switch(pickaxes) {
            case 1:
                dPoint = 5;
                break;
            case 2:
                dPoint = 25;
                iPoint = 5;
                break;
        }
        
        // 5개의 광물을 캘 때 피로도 계산
        int length = count + 5 > minerals.length ? minerals.length : count + 5;
        for(int i = count; i < length; i++) {
            if(minerals[i].equals("diamond")) {
                tiredness += dPoint;
            } else if(minerals[i].equals("iron")) {
                tiredness += iPoint;
            } else {
                tiredness += sPoint;
            }
        }
        
        if(tiredness >= answer) return;
        
        if((picks[0] == 0 && picks[1] == 0 && picks[2] == 0) || (length >= minerals.length)) {
            answer = Math.min(answer, tiredness);
            return;
        }
        
        // 다음 곡괭이 선정
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] == 0) continue;
            dfs(i, picks, minerals, count + 5, tiredness);
            picks[i]++;
        }
        
    }
}
