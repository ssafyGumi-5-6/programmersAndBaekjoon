import java.util.*;

class Solution1016 {
    public static ArrayList<String> list = new ArrayList<>(); // 모든 후보키 조합 저장
    public static ArrayList<List<String>> candidateKeyList = new ArrayList<>(); // 유일성, 최소성 만족하는 후보키 저장
    static int row;
    static int col;


    public static int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        // 부분 집합으로 경우의 수를 모두 구한다.
        subset(0, new boolean[col]);

        for (int i = 0; i < list.size(); i++) {

            // 현재 부분 집합 하나를 String 배열에 각각 저장
            String[] key = list.get(i).split("");
            Set<String> set = new HashSet<>();

            // 각각의 행을 합친 후, set에 저장
            // 중복일 경우 하나만 저장됨
            for (int inR = 0; inR < relation.length; inR++) {
                String inS = "";
                for (int k = 0; k < key.length; k++) {
                    inS += relation[inR][Integer.parseInt(key[k])];
                }
                set.add(inS);
            }

            // 중복된 것이 없다면
            if (set.size() == relation.length) {
                List<String> checkList = Arrays.asList(list.get(i).split(""));
                boolean checkCandidate = false;

                // 현재 저장된 후보키에서 checkList가 포함되어 있는지 확인한다.
                // checkList : [1 2 3], candidateKeyList : [[1, 2, 3, 4, 5], [2], [3]] : true
                // checkList : [1 2 3], candidateKeyList : [[1, 2, 4, 5], [2], [3]] : false
                for (int candiateIdx = 0; candiateIdx < candidateKeyList.size(); candiateIdx++) {
                    if (checkList.containsAll(candidateKeyList.get(candiateIdx))) {
                        checkCandidate = true;
                        break;
                    }
                }

                if (!checkCandidate) {
                    candidateKeyList.add(checkList);
                }
            }

        }
        return candidateKeyList.size();
    }

    public static void subset(int idx, boolean[] visited) {
        if (idx == col) {
            String s = "";
            for (int i = 0; i < col; i++) {
                if (visited[i]) {
                    s += Integer.toString(i);
                }
            }

            if (s != "") list.add(s);
            return;
        }

        subset(idx + 1, visited);
        visited[idx] = true;
        subset(idx + 1, visited);
        visited[idx] = false;
    }


    public static void main(String[] args) {

//        String[][] inputString = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}
//        };

//        String[][] inputString = {{"a","aa"},{"aa","a"},{"a","a"}};
//
//        String[][] inputString = { {"a","1","aaa","c","ng"},
//                {"a","1","bbb","e","g"},
//                {"c","1","aaa","d","ng"},
//                {"d","2","bbb","d","ng"}};
//

        String[][] inputString = {{"a", "1", "aaa", "c", "ng"}, {"b", "1", "bbb", "c", "g"}, {"c", "1", "aaa", "d", "ng"}, {"d", "2", "bbb", "d", "ng"}};
        solution(inputString);

    }
}
