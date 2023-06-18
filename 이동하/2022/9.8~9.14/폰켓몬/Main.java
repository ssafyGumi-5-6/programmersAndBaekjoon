import java.util.HashSet;

public class Main {
	static int solution(int[] nums) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i : nums) hs.add(i);
		return Math.min(hs.size(), nums.length/2);
    }
	public static void main(String[] args) {
		int [] nums = {3,1,2,3};
		System.out.println(solution(nums));
	}
}
