import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    static class Data {
        String inOut;
        int inTime;
        int totalTime;
        
        public Data(int time, String inOut, int totalTime) {
            this.inOut = inOut;
            this.inTime = time;
            this.totalTime = totalTime;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Data> map = new HashMap<>();
        for (String s : records) {
            String[] str = s.split(" ");
            String time = str[0];
            String carNum = str[1];
            String inOut = str[2];
            String[] hm = time.split(":");
            
            int minute = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
             if(inOut.equals("IN")) {
                 if(map.get(carNum) == null) {
                    map.put(carNum, new Data(minute, "IN", 0));   
                } else {
                    map.put(carNum, new Data(minute, "IN", map.get(carNum).totalTime));
                }
            } else {
                minute -= map.get(carNum).inTime;
                map.put(carNum, new Data(0, "OUT", map.get(carNum).totalTime + minute));
            }  
        }
        int lastTime = 23 * 60 + 59;
        Object[] keySort = map.keySet().toArray();
        Arrays.sort(keySort);
        int[] answer = new int[keySort.length];
        for(int i = 0; i < keySort.length; i++) {
            int t = 0;
            if(map.get(keySort[i]).inOut.equals("IN")) {
                t = lastTime - map.get(keySort[i]).inTime;
            }
            int feeTime = map.get(keySort[i]).totalTime + t;
            int fee = 0;
            feeTime -= fees[0];
            fee += fees[1];
            if(feeTime > 0) {
                fee += (feeTime % fees[2] > 0 ? feeTime / fees[2] + 1 : feeTime / fees[2]) * fees[3];
            }
            answer[i] = fee;
        }
        
        
        return answer;
    }
}