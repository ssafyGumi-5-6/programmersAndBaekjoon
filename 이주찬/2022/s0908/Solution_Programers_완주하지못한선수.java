import java.util.Arrays;
class Solution_Programers_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String no_complet=null;
        int cnt = 0;
        String exp;
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i = 0; i < participant.length-1; i++) {
            if((participant[i].equals(completion[i]))) {
                continue;
            }
            else if(!(participant[i].equals(completion[i]))) {
                no_complet = participant[i];
                break;
            }            
        }
        if(no_complet == null) no_complet = participant[participant.length-1];
        String answer = no_complet;
        return answer;
    }
}