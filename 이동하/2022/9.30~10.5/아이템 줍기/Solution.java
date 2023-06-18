import java.util.Arrays;
import java.util.LinkedList;

class Node {
	int x;
	int y;
	int step;
	Node(int x, int y, int step) {
		this.x = x;
		this.y = y;
		this.step = step;
	}
}

class Solution {
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int [] [] map = new int [101] [101], delta = {{0,1},{1,0},{0,-1},{-1,0}}, delta2 = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int answer = 0;
        for (int [] r : rectangle) {
        	for (int i = r[0] * 2; i <= r[2] * 2; i++) {
        		for (int j = r[1] * 2; j <= r[3] * 2; j++) {
        			map[i][j] = 1;
        		}
        	}
        }
        for (int [] i : map) System.out.println(Arrays.toString(i));
        LinkedList<Node> q = new LinkedList<>();
        q.offer(new Node(characterX * 2, characterY * 2, 0));
        map[characterX * 2][characterY * 2] = 2;
        Loop1:
        while (q.size() > 0) {
        	Node present = q.poll();
        	for (int [] d : delta) {
        		int next_x = present.x + d[0];
        		int next_y = present.y + d[1];
        		if (next_x < 0 || next_x >= 101 || next_y < 0 || next_y >= 101) continue;
        		if (map[next_x][next_y] != 1) continue;
        		boolean flag = false;
        		for (int [] di : delta2) {
        			int nnx = next_x + di[0];
        			int nny = next_y + di[1];
        			if (nnx < 0 || nnx >= 101 || nny < 0 || nny >= 101 || map[nnx][nny] == 0) {flag = true; break;}
        		}
        		if (flag == false) continue;
        		if (next_x == itemX * 2 && next_y == itemY * 2) {
        			answer = (present.step + 1) / 2;
        			break Loop1;
        		}
        		map[next_x][next_y] = 2;
        		q.offer(new Node(next_x, next_y, present.step+1));
            	for (Node n : q) {
            		System.out.print(n.x + " " + n.y + "  /  ");
            	}
            	System.out.println();
        	}
//        	break;
        }
        System.out.println(answer);
        return 0;
    }
    public static void main(String[] args) {
		new Solution().solution(new int [] [] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1, 3, 7, 8);
		new Solution().solution(new int [] [] {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}}, 9, 7, 6, 1);
		new Solution().solution(new int [] [] {{1,1,5,7}}, 1, 1, 4, 7);
		new Solution().solution(new int [] [] {{2,1,7,5},{6,4,10,10}}, 3, 1, 7, 10);
		new Solution().solution(new int [] [] {{2,2,5,5},{1,3,6,4},{3,1,4,6}}, 1, 4, 6, 3);
	}
}