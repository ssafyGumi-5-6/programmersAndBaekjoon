import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	static int [] solution(String[] id_list, String[] report, int k) {
		HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
		HashMap<String, ArrayList<String>> yarareru = new HashMap<>();
		HashMap<String, Integer> kaisuu = new HashMap<>();
		int [] answer = new int[id_list.length];
		for (String id : id_list) {
			yarareru.put(id, new ArrayList<String>());
			kaisuu.put(id, 0);
		}
		for (String r : reportSet) {
			String [] temp = r.split(" ");
			yarareru.get(temp[1]).add(temp[0]);
		}
		for (String id : id_list) {
			if (yarareru.get(id).size() >= k) {
//				System.out.println(yarareru.get(id));
				for (String i : yarareru.get(id)) {
//					System.out.println(i);
					kaisuu.put(i, kaisuu.get(i)+1);
				}
			}
		}
		int idx = 0;
		for (String id : id_list) {
//			System.out.println(kaisuu.get(id));
			answer[idx++] = kaisuu.get(id);
		}
		System.out.println(Arrays.toString(answer));
		return answer;
    }
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		solution(id_list, report, k);
	}
}
