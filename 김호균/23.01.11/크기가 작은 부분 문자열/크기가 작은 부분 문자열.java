class Solution {
    public int solution(String t, String p) {
        // 최대 만자리 숫자가 가능하므로 int로 받아서는 안된다.
        int answer = 0;
        long pNumber = Long.parseLong(p); 
        for(int i = 0; i + p.length() <= t.length(); i++) {
            if( Long.parseLong(t.substring(i, i + p.length())) <= pNumber) {
                answer++;
            }
        }
        return answer;
    }
}
