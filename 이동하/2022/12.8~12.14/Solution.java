import java.util.LinkedList;

class Node {
	int r;
	int c;
	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Solution {
    public int[] solution(int m, int n, int[][] pic) {
    	int [] [] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    	int [] answer = {0, -1};
    	int [] [] picture = new int [m] [n];
    	for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) picture[i][j] = pic[i][j];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (picture[i][j] == 0) continue;
        		LinkedList<Node> q = new LinkedList<>();
        		q.offer(new Node(i, j));
        		int temp = picture[i][j];
        		picture[i][j] = 0;
        		int cnt = 1;
        		while(q.size() > 0) {
        			Node present = q.poll();
        			for (int [] d : delta) {
        				Node next = new Node(present.r + d[0], present.c + d[1]);
        				if (next.r < 0 || next.r >= m || next.c < 0 || next.c >= n) continue;
        				if (picture[next.r][next.c] != temp) continue;
        				picture[next.r][next.c] = 0;
        				cnt++;
        				q.offer(next);
        			}
        		}
        		answer[0]++;
        		answer[1] = Math.max(answer[1], cnt);
        	}
        }
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }
    public static void main(String[] args) {
		new Solution().solution(6, 4, new int [] [] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
	}
}