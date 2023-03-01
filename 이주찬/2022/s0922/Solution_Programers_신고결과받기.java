import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_Programers_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, User> users = new HashMap<String, User>();
        for(String id : id_list) {
            User user = new User(id);
            users.put(id, user);

        }
        for(int i = 0; i < report.length; i++) {
            String[] repArr = report[i].split(" ");
            users.get(repArr[0]).reportSb(users.get(repArr[1]));
        }
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = users.get(id_list[i]).getMails(k);
        }



        return answer;
    }
}

class User {
    private String username;
    private int reported = 0;
    private List<User> reporting = new ArrayList<>();
    User(String username) {
        this.username = username;
    }
    void reportSb(User beReported) {
        if(!reporting.contains(beReported)) {
            reporting.add(beReported);
            beReported.beReported();
        }
    }
    void beReported() {
        this.reported += 1;
    }
    int getReported() {
        return this.reported;
    }
    int getMails(int k) {
        int mails = 0;
        for(User user : this.reporting) {
            if(user.getReported() >= k) mails++;
        }
        return mails;
    }
}