import java.util.ArrayList;
import java.util.List;

public class pg84512 {

    // 제출한 소스
    static int[] dp;
    static String inalpha = "AEIOU";

    // AAA 3
    // AAAA 4
    // AAAAA 5
    // AAAAE 6
    // ~
    // AAAAU 9
    // AAAE 10
    // ~
    // AAE 34
    // AAAAA 1, AAAA 6, AAA 31, ~

    public int solution(String word) {
        int answer = word.length();
        dp = new int[5];

        dp[0] = 1;
        for (int i = 1; i < 5; i++) {
            dp[i] = dp[i - 1] * 5 + 1;
        }

        for (int i = 0; i < word.length(); i++) {
            answer += dp[4 - i] * inalpha.indexOf(word.charAt(i));
        }

        return answer;
    }

    // 참고 1
//    static List<String> list = new ArrayList<>();
//
//    static void dfs(String s, int len){
//        if(len > 5) return;
//        list.add(s);
//        for(int i =0;i<5;i++) dfs(s + "AEIOU".charAt(i), len + 1);
//    }
//
//    public int solution(String word){
//        dfs("",0);
//        return list.indexOf(word);
//    }

}
