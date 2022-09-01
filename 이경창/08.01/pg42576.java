import java.util.*;

class pg42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i <Math.min(participant.length, completion.length); i++){
            if(!participant[i].equals(completion[i])){
                System.out.println(i);
                if(participant.length > completion.length){
                    answer = participant[i];
                }else{
                    answer = completion[i];
                }
                break;
            }
        }

        if(answer == ""){
            answer = participant[participant.length - 1];
        }


        return answer;
    }
}