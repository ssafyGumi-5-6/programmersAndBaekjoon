package 비슷한_단어;

public class Test {

    public static String findLongestCommonSubstring(char[] c1, char[] c2) {
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1; // or j - 1, since both indices will be the same
                    }
                }
            }
        }

        if (maxLength == 0) {
            return ""; // No common substring found
        }

        return new String(c1).substring(endIndex - maxLength + 1, endIndex + 1);
    }

    public static void main(String[] args) {
        String s1 = "CAABCADSE";
        String s2 = "BACADFG";
        
        String commonSubstring = findLongestCommonSubstring(s1.toCharArray(), s2.toCharArray());
        System.out.println("Common Substring: " + commonSubstring);
    }
}
