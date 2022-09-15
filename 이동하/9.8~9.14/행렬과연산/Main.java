import java.util.ArrayDeque;

public class Main {
	static int[][] solution(int [] [] rc, String [] operations) {
		int r = rc.length;
		int c = rc[0].length;
		ArrayDeque<ArrayDeque<Integer>> mid = new ArrayDeque<>();
		ArrayDeque<Integer> left = new ArrayDeque<>();
		ArrayDeque<Integer> right = new ArrayDeque<>();
		
		for (int i = 0; i < r; i++) left.offer(rc[i][0]);
		for (int i = 0; i < r; i++) {
			ArrayDeque<Integer> temp = new ArrayDeque<>();
			for (int j = 1; j < c-1; j++) temp.offer(rc[i][j]);
			mid.offer(temp);
		}
		for (int i = 0; i < r; i++) right.offer(rc[i][c-1]);
		
		for (String o : operations) {
			if (o.equals("Rotate")) {
				mid.getFirst().offerFirst(left.pollFirst());
				right.offerFirst(mid.getFirst().pollLast());
				mid.getLast().offerLast(right.pollLast());
				left.offerLast(mid.getLast().pollFirst());
			} else if (o.equals("ShiftRow")) { 
				left.offerFirst(left.pollLast());
				mid.offerFirst(mid.pollLast());
				right.offerFirst(right.pollLast());
			}
		}
		for(int i = 0; i < r; i++) {
			rc[i][0] = left.pollFirst();
			for(int j = 0; j < c-2; j++) {
				rc[i][j+1] = mid.getFirst().pollFirst();
			}
			mid.pollFirst();
			rc[i][c-1] = right.pollFirst();
		}
//		for (int [] i : rc) System.out.println(Arrays.toString(i));
		return rc;
	}
	public static void main(String[] args) {
//		int [] [] rc = {{1,2,3},{4,5,6},{7,8,9}};
//		String [] operations = {"Rotate", "ShiftRow"};
//		int [] [] rc = {{8,6,3},{3,3,7},{8,4,9}};
//		String [] operations = {"Rotate", "ShiftRow", "ShiftRow"};
		int [] [] rc = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		String [] operations = {"ShiftRow", "Rotate", "ShiftRow", "Rotate"};
		
		solution(rc, operations);
	}
}
