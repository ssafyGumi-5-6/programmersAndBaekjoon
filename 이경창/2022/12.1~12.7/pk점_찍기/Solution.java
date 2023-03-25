package pk점_찍기;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i * k <= d; i++) {
            double y2 = Math.pow(d, 2) - Math.pow(i * k, 2);
            answer += (int) (Math.sqrt(y2) / k) + 1;
        }

        return answer;
    }
}