import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        // 전체 일수로 구해서 계산하면 훨씬 쉽게 비교할 수 있다.
        int todayDays = getTotalDays(today);
        
        Map<String, Integer> periodOfTerms = new HashMap<>();
        for(String s : terms) {
            String[] termsAndPeriod = s.split(" ");
            periodOfTerms.put(termsAndPeriod[0], Integer.parseInt(termsAndPeriod[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] dateAndTerms = privacies[i].split(" ");
            /*
             * (개인정보 수집 일자 + 유효기간) - 1이 오늘 날짜보다 작아야 파기하지 않는다.
             * 따라서 일수로 비교할 때는 아래 조건을 만족해야 파기하지 않는다.
             * (개인정보 수집 일자 + 유효기간) > (오늘 날짜)
             * 역으로 파기 조건은 (개인정보 수집 일자 + 유효기간) <= (오늘 날짜)이 된다.
             */
            if(getTotalDays(dateAndTerms[0]) + periodOfTerms.get(dateAndTerms[1]) * 28 <= todayDays)
                    answer.add(i + 1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private int getTotalDays(String dateFormat) {
        String[] date = dateFormat.split("\\.");
        return Integer.parseInt(date[0]) * 12 * 28 + Integer.parseInt(date[1]) * 28 + Integer.parseInt(date[2]);
    }
}
