import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int answer = Integer.MAX_VALUE;
		int n = Integer.parseInt(br.readLine());
		boolean [][] start = new boolean[2][n];
		boolean [] end = new boolean[n];
		int idx;
		idx = 0;
		for (char i : br.readLine().toCharArray()) {
			if (i == '1') {start[0][idx] = true; start[1][idx++] = true;}
			else {start[0][idx] = false; start[1][idx++] = false;}
		}
		start[1][0] = !start[1][0]; start[1][1] = !start[1][1];
		idx = 0;
		for (char i : br.readLine().toCharArray()) {
			if (i == '1') end[idx++] = true;
			else end[idx++] = false;
		}
		for (int x = 0; x <= 1; x++) {
			int cnt = 0;
			for(int i = 1; i < n-1; i++) {
				if (start[x][i-1] != end[i-1]) {
					start[x][i-1] = !start[x][i-1];
					start[x][i] = !start[x][i];
					start[x][i+1] = !start[x][i+1];
					cnt++;
				}
			}
			if(start[x][n-2] != end[n-2]) {
				start[x][n-2] = !start[x][n-2];
				start[x][n-1] = !start[x][n-1];
				cnt++;
			}
			if (start[x][n-1] == end[n-1]) {
				answer = Math.min(answer, x+cnt);
			}
		}
		if (answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
}