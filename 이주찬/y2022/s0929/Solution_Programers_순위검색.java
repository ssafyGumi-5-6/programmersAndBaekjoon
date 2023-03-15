import java.util.StringTokenizer;

public class Solution_Programers_순위검색 {
    
}
class Solution_순위검색 {
    public int[] solution(String[] info, String[] query) {
        int n = info.length;
        int m = query.length;
        int[] answer = new int[m];
        String[][] infoArr = new String[n][5];
        for (int i = 0; i < n; i++) {
            // java backend junior pizza 150
            infoArr[i] = info[i].split(" ");
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(query[i], " ");
            // java and backend and junior and pizza 100
            String[] q = new String[4];
            for (int j = 0; j < 3; j++) {
                q[j] = st.nextToken();
                st.nextToken();
            }
            q[3] = st.nextToken();
            int point = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                if((q[0].equals("-") || q[0].equals(infoArr[j][0]))
                && (q[1].equals("-") || q[1].equals(infoArr[j][1]))
                && (q[2].equals("-") || q[2].equals(infoArr[j][2]))
                && (q[3].equals("-") || q[3].equals(infoArr[j][3]))
                        && (point <= Integer.parseInt(infoArr[j][4])))
                    answer[i]++;
            }
        }
        return answer;
    }
}

class Info {
    String lang;
    String ;
    String c;
    String d;

}