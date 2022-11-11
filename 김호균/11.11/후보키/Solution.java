import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;

class Solution {
    List<String> visited;
    int answer;
    public int solution(String[][] relation) {
        answer = 0;
        int n = relation[0].length;
        // 후보키 패턴 모음
        visited = new ArrayList<>(); 
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            // 중복없는 조합 생성
            comb(n, i, relation, 0, 0, sb);
        }
        return answer;
    }
    
    public void comb(int n, int r, String[][] relation, int cnt, int start, StringBuilder sb) {
        if(cnt == r) { // 조합 완성 되면 진입
            
            // 기존에 있던 후보키 조합과 일치하면 리턴(최소성 확인)
            String candidateKeyIndex = sb.toString();
            for(String s : visited) {
                if(Pattern.matches(s, sb.toString())) return;
            }
            
            // 아니면 유일성 확인 -> 후보키 조합(sb)은 컬럼의 인덱스 값이다. 
            // sb의 각 문자를 숫자로 변경하여 해당 열 내에 데이터를 문자열에 저장한다.
            // 그 후 Set에 넣어 set의 크기를 이용해 유일성이 보장되는지 확인한다.
            Set<String> set = new HashSet<>();
            for(int j = 0; j < relation.length; j++) {
                String tmp = ""; // 후보키 조합의 인덱스의 데이터를 담기위한 임시 문자열
                for(int i = 0; i < candidateKeyIndex.length(); i++) {
                    int index = candidateKeyIndex.charAt(i) - '0';
                    tmp += relation[j][index];
                }
                set.add(tmp);
            }
            
            // 유일성 확인 결과 후보키가 가능하면
            if(set.size() == relation.length) {
                // 후보키 조합을 문자열 패턴으로 변경한다.
                sb = new StringBuilder();
                sb.append("^\\w*");
                for(int i = 0; i < temp.length(); i++) {
                    sb.append(temp.charAt(i)).append("\\w*");
                }
                sb.append('$');
                visited.add(sb.toString());
                answer++;
            }
            return;
        }
        
        // 중복 없는 조합
        for(int i = start; i < n; i++) {
            sb.append(i);
            comb(n, r, relation, cnt + 1, i + 1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}