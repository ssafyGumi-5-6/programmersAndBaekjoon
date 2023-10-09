import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main_Bj_2631_줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine()) - 1;
            arr[i] = tmp;
            list.add(tmp);
        }
        int answer = 0;

        int idx = 0;
        int endIdx = n - 1;
        while (true) {
            System.out.println(Arrays.toString(list.toArray()));
            for (int i = 0; i < n; i++) {
                if (list.get(i) == idx && idx != i) {
                    list.add(idx, list.remove(i));
                    answer++;
                    break;
                } else if (list.get(i) == idx && idx == i) {
                    break;
                }
            }
            System.out.println(Arrays.toString(list.toArray()));
            for (int i = n - 1; i >= 0; i--) {
                if (list.get(i) == endIdx && endIdx != i) {
                    list.add(endIdx, list.remove(i));
                    answer++;
                    break;
                } else if (list.get(i) == endIdx && endIdx == i) {
                    break;
                }
            }
            idx++;
            endIdx--;
            if (idx == n) {
                break;
            }
        }

        System.out.println(answer);

    }
}
