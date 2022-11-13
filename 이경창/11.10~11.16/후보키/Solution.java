import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    static int relLen;
    static int answer;

    // 중복한 개 있는지 확인하기
    static boolean duplication(String[] dup){
        Map<String, Integer> map = new HashMap<>();
        for(String in_res : dup){
            Integer in_value = map.get(in_res);
//            System.out.println("in_res : " + in_res + " " + in_value);
            if(in_value == null) map.put(in_res, 1);
            else return false;
        }

        return true;
    }

    static void backtracking(int index, String indexStr,String[] res, Map<String, Integer> map, String[][] relation){

        if(index == relation.length){
            answer = Math.max(answer, map.size());
            System.out.println("결과 res : " + res.toString() + " map : " + map  + " answer : " + answer );
            return;
        }

        // 현재 구간 확인한다.
        boolean check = duplication(relation[index]);

        System.out.println("현재 index" + index + " check "  +check + "  " + indexStr);
        // 만약 후보키라면 저장한다.
        if(check){
            backtracking(index + 1, indexStr, res, map, relation);
            map.put(Integer.toString(index), 1);
            backtracking(index + 1, indexStr, res, map, relation);

        }else{
            // 현재 index가 후보키가 아니라면 이전 현재 저장된 문자열에 추가
            for(int i = 0; i < res.length; i++){
                res[i] += relation[index][i];
            }

            // 합쳤을 때 후보키라면 res에 저장된거 제거하고 결과에 저장
            boolean check2 = duplication(res);
            if(check2){
                indexStr += Integer.toString(index);
                if(!map.containsKey(indexStr)) map.put(indexStr, 1);
                backtracking(index + 1,"",new String[relLen], map, relation);
            }else{
                backtracking(index + 1, indexStr + index, res, map, relation);
            }
        }


        // map에 넣을 때 get(String)이 null이라면 넣는다.

    }

    static int solution(String[][] relation) {
        String[][] relationData = new String[relation[0].length][relation.length];
        for(int i = 0; i < relation[0].length; i++){
            for(int j =0; j< relation.length; j++){
                relationData[i][j] = relation[j][i];
            }
        }

        int answer = 0;
        relLen = relationData[0].length;
        backtracking(0, "" ,new String[relLen],new HashMap<>(), relationData );
        return answer;
    }

    public static void main(String[] args) {

//        String[][] inputString = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}
//        };

//        String[][] inputString = {{"a","aa"},{"aa","a"},{"a","a"}};
//
//        String[][] inputString = { {"a","1","aaa","c","ng"},
//                {"a","1","bbb","e","g"},
//                {"c","1","aaa","d","ng"},
//                {"d","2","bbb","d","ng"}};
//

        String[][] inputString = {{"a","1","aaa","c","ng"},{"b","1","bbb","c","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"} };
        solution(inputString);
    }
}
