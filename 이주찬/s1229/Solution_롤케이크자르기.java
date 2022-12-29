package s1229;

public class Solution_롤케이크자르기 {

}

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        boolean[] big = new boolean[10001];
        boolean[] small = new boolean[10001];
        int[] bigTopping = new int[len];
        int[] smallTopping = new int[len];
        bigTopping[0] = 1;
        big[topping[0]] = true;
        smallTopping[len - 1] = 1;
        small[topping[len - 1]] = true;
        for (int i = 1; i < len - 1; i++) {
            if (!big[topping[i]]) {
                bigTopping[i] = bigTopping[i - 1] + 1;
                big[topping[i]] = true;
            } else {
                bigTopping[i] = bigTopping[i - 1];
            }
            if (!small[topping[len - 1 - i]]) {
                smallTopping[len - 1 - i] = smallTopping[len - i] + 1;
                small[topping[len - 1 - i]] = true;
            } else {
                smallTopping[len - 1 - i] = smallTopping[len - i];
            }
        }
        for (int i = 0; i < len - 1; i++) {
            if (bigTopping[i] == smallTopping[i + 1]) {
                answer++;
            }
        }
        return answer;
    }
}