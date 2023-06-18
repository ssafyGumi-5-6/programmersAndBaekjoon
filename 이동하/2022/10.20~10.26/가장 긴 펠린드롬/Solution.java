class Solution {
	public int solution(String s) {
		int s_len = s.length();
		int answer = 0;
		for (int i = 0; i < s_len; i++) {
			int interval = 1;
			while (true) {
				if (i-interval < 0) break;
				if (i+interval >= s_len) break;
				if (s.charAt(i-interval) != s.charAt(i+interval)) break;
				interval++;
			}
			answer = Math.max(answer, 2*interval - 1);
		}
        for (int i = 0; i < s_len-1; i++) {
            int interval = 1;
            while (true) {
                if (i - interval + 1 < 0) break;
                if (i + interval >= s_len) break;
                if (s.charAt(i - interval + 1) != s.charAt(i + interval)) break;
                interval++;
            }
            answer = Math.max(answer, 2*interval-2);
        }
		return answer;
    }
    public static void main(String[] args) {
		new Solution().solution("abcdcba");
		new Solution().solution("abacde");
	}
}