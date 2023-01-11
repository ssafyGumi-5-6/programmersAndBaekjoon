package s1006;

import java.util.PriorityQueue;

public class PROG12927 {
	public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for(int i : works) {
            pq.add(i);
        }
        
        while ( n != 0) {
            int v = pq.poll();
            pq.add(v > 0 ? v - 1 : 0);
            n--;
        }
        
        for (int i : pq) {
            answer += i * i;
        }
        
        return answer;
    }
}
