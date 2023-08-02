import java.util.*;

class Solution {
    static class Data {
        int start;
        int end;
        int time;
        
        public Data (int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        int leftConsultants = n - k;
        // 상담 유형 별로 상담사 수에 따른 대기 시간을 저장하는 배열
        int[][] waitTimesByConsultantType = new int[k][leftConsultants + 1];
        
        List<ArrayList<Data>> bookingList = new ArrayList<>();
        for(int i = 0; i < k; ++i) {
            bookingList.add(new ArrayList<>());
        }
        
        // 상담 유형 별로 분류 작업
        for(int i = 0; i < reqs.length; ++i) {
            bookingList.get(reqs[i][2] - 1)
                .add(new Data(reqs[i][0], reqs[i][0] + reqs[i][1], reqs[i][1]));
        }
        
        for(int i = 0; i <= leftConsultants; ++i) {
            for(int j = 0; j < k; ++j) {
                // 상담사가 진행 중인 상담
                List<Data> consultantSchedule = new ArrayList<>();
                
                for(int p = 0; p < bookingList.get(j).size(); ++p) {
                    Data currentBooking = bookingList.get(j).get(p);
                    
                    // 상담사 인원 만큼 상담사가 진행 중인 상담 목록을 만든다.
                    if(consultantSchedule.size() < i + 1) {
                        consultantSchedule.add(currentBooking);
                    } 
                    // 모든 상담사가 상담 중이기 때문에 대기를 해야 한다면
                    else if(consultantSchedule.get(0).end - currentBooking.start >= 0){
                        
                        // 대기 시간 저장
                        waitTimesByConsultantType[j][i] 
                            += consultantSchedule.get(0).end - currentBooking.start;
                        
                        // 가장 빨리 상담이 끝나는 상담사의 종료시간을 현재 예약 정보로 갱신
                        consultantSchedule.set(
                            0, 
                            new Data(
                                consultantSchedule.get(0).end, 
                                consultantSchedule.get(0).end + currentBooking.time, 
                                currentBooking.time
                            )
                        );
                    } 
                    // 상담 종료 시간 이후 예약이 있다면 
                    else {
                         // 가장 빨리 상담이 끝나는 상담사의 종료시간을 현재 예약 정보로 갱신
                        consultantSchedule.set(
                            0, 
                            new Data(
                                currentBooking.start, 
                                currentBooking.end, 
                                currentBooking.time
                            )
                        );
                    }
                    
                    // 상담 종료 시간 기준으로 오름차순 정렬
                    consultantSchedule.sort(new Comparator<Data>() {
                        @Override
                        public int compare(Data o1, Data o2) {

                            return o1.end - o2.end;
                        }
		            });
                    
                  
                }

            }
        }

        int[] index = new int[k];
        // 각 유형별로 한 명씩 배치하고 남은 상담사 배분
        while(--leftConsultants >= 0) {
            int max = 0;
            int lastIndex = 0;
            for(int i = 0; i < k; ++i) {
                // 각 유형 별로 상담사를 추가했을 때 발생하는 차이
                int diff = waitTimesByConsultantType[i][index[i]] 
                    - waitTimesByConsultantType[i][index[i] + 1];
                
                // 그 차이가 최대값이면 해당 유형을 저장한다.
                if(max < diff) {
                    max = diff;
                    lastIndex = i;
                }
            }
            
           // 해당 유형 상담사 수를 증가한다.
            ++index[lastIndex];    
        }
        
        // 최종 대기 시간 연산
        for(int i = 0; i < k; ++i) {
            answer += waitTimesByConsultantType[i][index[i]];
        }
        
        return answer;
    }
}
