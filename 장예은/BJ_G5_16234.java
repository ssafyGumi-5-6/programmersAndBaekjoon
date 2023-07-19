import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, L, R, map[][], ans;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		boolean flag = true;
		while (flag) {
			visited = new boolean[N][N];
			if (bfs() == 0) {
				flag = false;
			} else {
				ans++;
			}
		}
		System.out.println(ans);
	}

	private static int bfs() {
		int count = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (!visited[x][y]) {
					List<Point> list = new ArrayList<>();
					Queue<Point> q = new LinkedList<>();

					visited[x][y] = true;
					list.add(new Point(x, y));
					q.offer(new Point(x, y));

					int sum = map[x][y];
					while (!q.isEmpty()) {
						Point cur = q.poll();
						for (int d = 0; d < 4; d++) {
							int nx = cur.x + dx[d];
							int ny = cur.y + dy[d];
							if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
								continue;
							}
							int diff = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
							if (diff >= L && diff <= R) {
								visited[nx][ny] = true;
								list.add(new Point(nx, ny));
								q.offer(new Point(nx, ny));
								count++;
								sum += map[nx][ny];
							}
						}
					}
					if (count > 0) {
						for (Point p : list) {
							map[p.x][p.y] = sum / list.size();
						}
					}
				}
			}
		}
		return count;
	}
}
