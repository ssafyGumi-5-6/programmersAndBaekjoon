import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String[][] book_time) {
        // 시작 시간 기준 오름차순 정렬
        Arrays.sort(book_time, (String[] arr1, String[] arr2) -> timeToInteger(arr1[0]) - timeToInteger(arr2[0]));
        
        // 대여 후 청소가 끝나는 시간을 저장할 리스트
        List<Integer> clearRoomTime = new ArrayList<>();
        // 가장 먼저 대여되는 방 저장
        clearRoomTime.add(timeToInteger(book_time[0][1]) + 10);
        
        for(int i = 1; i < book_time.length; i++) {
            boolean isNew = true;
            for(int j = 0; j < clearRoomTime.size(); j++) {
                // 청소가 끝나는 시간후 다음 예약이 있으면 해당 방을 대여해준다.
                if(timeToInteger(book_time[i][0]) >= clearRoomTime.get(j)) {
                    clearRoomTime.set(j, timeToInteger(book_time[i][1]) + 10);
                    isNew = false;
                    break;
                }
            }
            // 예약시간 전에 청소가 끝나는 방이 없으면 새로운 방 생성
            if(isNew) clearRoomTime.add(timeToInteger(book_time[i][1]) + 10);
        }
        
        // 현재 있는 방 크기 반환
        return clearRoomTime.size();
    }
    
    // 시간 형식을 int로 바꿔준다
    private int timeToInteger(String time) {
        String[] hourAndMin = time.split(":");
        return Integer.parseInt(hourAndMin[0]) * 60 + Integer.parseInt(hourAndMin[1]);
    }
}
