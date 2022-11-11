import java.util.LinkedList;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        int len = queue1.length;
        long s1 = 0, s2 = 0;
        for (int i = 0; i < len; i++) {
        	s1 += queue1[i]; s2 += queue2[i];
        	q1.add(queue1[i]); q2.add(queue2[i]);
        }
        if ((s1 + s2) % 2 == 1) return -1;
        int answer = 0;
        boolean flag = false; 
        while (s1 > 0 && s2 > 0 && answer < 600000) {
        	if (s1 > s2) {
        		int temp = q1.poll();
        		q2.add(temp);
        		s1 -= temp;
        		s2 += temp;
        	} else if (s2 > s1) {
        		int temp = q2.poll();
        		q1.add(temp);
        		s2 -= temp;
        		s1 += temp;
        	} else {
//        		System.out.println("찾음!!!!");
        		flag = true;
        		break;
        	}
        	answer++;
        }
//        System.out.println(flag ? answer : -1);
        return flag ? answer : -1;
    }
    public static void main(String[] args) {
		new Solution().solution(new int [] {3, 2, 7, 2}, new int [] {4, 6, 5, 1});
		new Solution().solution(new int [] {1, 2, 1, 2}, new int [] {1, 10, 1, 2});    	
		new Solution().solution(new int [] {1, 1}, new int [] {1, 5});
	}
}