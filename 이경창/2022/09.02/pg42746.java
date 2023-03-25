import java.util.*;

class pg42746 {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        for (int n : numbers) {
            list.add(Integer.toString(n));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2);
            }
        });

        // 0이면 아웃
        if (list.get(0).equals("0")) return "0";

        // 문자열을 "" 기준으로 합친다.
        return String.join("", list);
    }
}