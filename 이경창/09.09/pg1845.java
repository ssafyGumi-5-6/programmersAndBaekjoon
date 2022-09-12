import java.util.HashMap;

// 폰켓몬
class pg1845 {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (map.get(n) == null) {
                map.put(n, 1);
            } else {
                continue;
            }

            if (map.size() >= nums.length / 2) break;
        }

        return map.size();
    }
}
