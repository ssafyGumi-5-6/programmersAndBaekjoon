import java.util.Arrays;

public class 대충만든자판 {
    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"XABCD", "AABB"};
        int[] res = solution(keymap, targets);
        System.out.println(Arrays.toString(res));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        // target 비교
        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            // keymap 돌면서 비교
            for (int word = 0; word < targets[i].length(); word++) {
                int min = 999_999;
                for (int j = 0; j < keymap.length; j++) {
                    for (int k = 0; k < keymap[j].length(); k++) {
                        if (keymap[j].charAt(k) == targets[i].charAt(word)) {
                            min = Math.min(min, k + 1);
                            break;
                        }
                    }
                }
                if (min == 999_999) {
                    count = -1;
                    break;
                }
                else count += min;
            }
            answer[i] = count;
        }
        return answer;
    }
}
