package w1014;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_Programers_경주로건설 {

	public static void main(String[] args) {
		int[][] board = {
				{ 0, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 0, 1, 1, 0, 0 },
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0 },
				{ 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 1, 1, 0, 1, 1, 0 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 0 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 0, 0, 0 }
		};
		Solution sol = new Solution();
		System.out.println(sol.solution(board));
	}

	static class Solution {

		static int[] se = { -1, 1, 0, 0 };
		static int[] ga = { 0, 0, -1, 1 };

		public int solution(int[][] board) {
			int answer = 0;
			int N = board.length;
			int[][] d = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					d[i][j] = 9999999;
				}
			}
			d[0][0] = -500;

			Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					return o1.d - o2.d;
				}
			});

			pq.add(new Node(0, 0, -500, -1));
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				for (int s = 0; s < 4; s++) {
					int ys = cur.y + se[s];
					int xg = cur.x + ga[s];
					if (ys < 0 || xg < 0 || ys >= N || xg >= N || board[ys][xg] == 1)
						continue;
					int price = 100;
					if (cur.pd != s)
						price += 500;
					if (d[ys][xg] + 500 >= cur.d + price) {
						d[ys][xg] = cur.d + price;
						pq.add(new Node(ys, xg, d[ys][xg], s));
					}
				}
			}
			answer = d[N - 1][N - 1];
			return answer;
		}

		static void move(Node cur, int[][] board, int[][] d) {
			for (int s = 0; s < 4; s++) {
				int ys = cur.y + se[s];
				int xg = cur.x + ga[s];
				if (ys < 0 || xg < 0 || ys >= N || xg >= N || board[ys][xg] == 1)
					continue;
				int price = 100;
				if (cur.pd != s)
					price += 500;
				if (d[ys][xg] + 500 >= cur.d + price) {
					d[ys][xg] = cur.d + price;
					pq.add(new Node(ys, xg, d[ys][xg], s));
				}
			}
		}
	}

}

class Node {
	int y, x, d, pd;

	public Node(int y, int x, int d) {
		super();
		this.y = y;
		this.x = x;
		this.d = d;
	}

	public Node(int y, int x, int d, int pd) {
		super();
		this.y = y;
		this.x = x;
		this.d = d;
		this.pd = pd;
	}

}