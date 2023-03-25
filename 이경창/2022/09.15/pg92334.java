import java.util.*;


public class pg92334 {
    // 인덱스 저장 HashMap
    static HashMap<String, Integer> idxMap;

    // value에 중복 제거하는 HashMap
    static HashMap<String, HashSet<String>> map;

    static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        map = new HashMap<>();
        idxMap = new HashMap<>();

        // map에 삽입한다.
        for(int i =0 ; i< id_list.length; i++){
            idxMap.put(id_list[i], i);
            map.put(id_list[i], new HashSet<>());
        }

        for (String s : report) {
            String[] rs = s.split(" ");
            map.get(rs[1]).add(rs[0]);
        }

        for(int i= 0; i< id_list.length;i++){
            HashSet<String> s = map.get(id_list[i]);

            if(s.size() >= k){
                for (String s1 : s) {
                    answer[idxMap.get(s1)] +=1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        solution(id_list, report, k);
    }
}
