import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
    	for (int i : works) pq.offer(i);
    	for (int i = 0; i < n; i++) {
    		int temp = pq.poll();
    		if (temp == 0) break;
    		pq.offer(temp-1);
    	}
    	int answer = 0;
    	while (pq.size() > 0) {
    		int temp = pq.poll();
    		answer += temp*temp;
    	}
    	System.out.println(answer);
    	return answer;
    }
    public static void main(String[] args) {
		new Solution().solution(4, new int [] {4,3,3});
		new Solution().solution(1, new int [] {2,1,2});
		new Solution().solution(3, new int [] {1,1});
	}
}