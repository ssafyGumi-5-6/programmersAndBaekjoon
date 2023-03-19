package 호텔대실;

import java.util.*;

class HotelTime implements Comparable<HotelTime>{
    int startTime;
    int endTime;


    @Override
    public int compareTo(HotelTime h){
        // 시작시간을 기준으로 정렬
        // 시작시간이 같다면 종료시간을 기준으로 정렬
        if(this.startTime > h.startTime) return 1;
        else if(this.startTime == h.startTime){
            if(this.endTime > h.endTime) return 1;
            else return -1;
        }
        else return -1;
    }

}

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        // 마감시간 기반 10분간격
        // 시작시간을 기반으로 오름차순 정렬
        // 시간을 15:00 => 1500으로 바꾼다.
        // 60분 지날 시, +100 주고 분은 (현재 분 + 10) - 60으로 처리
        // - ex) 55분이라면 + 10 할경우 => (55+10) - 60 + 100
        int hotelTimeLen = book_time.length;

        // (1) book_time split 기반 int형 변경
        HotelTime[] hotelTimeList = new HotelTime[hotelTimeLen];
        for(int i =0 ; i < hotelTimeLen ; i++){
            hotelTimeList[i] = new HotelTime();
            String[] hotelTimeSplit = book_time[i][0].split(":");
            int startHour = Integer.parseInt(hotelTimeSplit[0]);
            int startMinute = Integer.parseInt(hotelTimeSplit[1]);

            hotelTimeList[i].startTime = startHour * 100 + startMinute;

            hotelTimeSplit = book_time[i][1].split(":");
            int endHour = Integer.parseInt(hotelTimeSplit[0]);
            int endMinute = Integer.parseInt(hotelTimeSplit[1]);
            int endTime = endHour * 100 + endMinute;

            // 10초 뒤 다음게임 진행됨
            // 50분부터는 시간 + 1
            if(endTime % 100 >= 50){
                int curMinute = endTime % 100 + 10 - 60;
                endTime += 100;
                endTime += (curMinute - (endTime % 100));
            }else{
                // 50분 전에는 + 10
                endTime += 10;
            }

            hotelTimeList[i].endTime = endTime;
        }


        Arrays.sort(hotelTimeList);

        // for(HotelTime h : hotelTimeList){
        //     System.out.println(h.startTime + " " + h.endTime);
        // }
        // System.out.println("시작");

        int arrive[] = new int[hotelTimeLen];

        for(int i = 0 ;i < hotelTimeLen; i++){
            for(int arriveIdx = 0; arriveIdx < hotelTimeLen; arriveIdx++){
                // System.out.println("arrive : " + arrive[arriveIdx] + " " + hotelTimeList[i].startTime );
                if(arrive[arriveIdx] <= hotelTimeList[i].startTime){
                    arrive[arriveIdx] = hotelTimeList[i].endTime;
                    break;
                }
            }
        }

        int idx = 0;
        // System.out.println("결과");
        for(; idx < hotelTimeLen; idx++){
            // System.out.println(arrive[idx]);
            if(arrive[idx] == 0) break;
        }

        answer = idx;

        return answer;
    }
}