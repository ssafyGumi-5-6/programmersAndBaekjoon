package 비슷한_단어;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution4 {

    private static int N;
    private static String[] str;

    private static int levenshteinDistance(char[] c1, char[] c2){
        int[][] dp = new int[c1.length + 1][c2.length + 1];

        int maxLen = 0;
        int endIndex = -1;
        for(int i = 1; i <= c1.length; i++){
            for(int j =1; j<= c2.length; j++){
                if(c1[i - 1] == c2[j - 1]){
                    dp[i][j] = dp[i -1][j -1] + 1;
                    if(maxLen < dp[i][j]){
                        maxLen = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        if(endIndex == -1) return 0;
        else return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        str = new String[N];
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        String left = "";
        String right = "";

        for(int i = 0; i < N; i++){
            str[i] = reader.readLine();
        }

        for(int i = 0; i < str.length; i++){
            for(int j = i + 1; j < str.length; j++){
                int result = levenshteinDistance(str[i].toCharArray(), str[j].toCharArray());
                if(result > answer){
                    answer = result;
                    left = str[i];
                    right = str[j];
                }
            }
        }

        System.out.println(left);
        System.out.println(right);


        reader.close();
    }
}
