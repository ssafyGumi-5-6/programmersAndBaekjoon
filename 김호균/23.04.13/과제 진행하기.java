import java.util.Stack;
import java.util.PriorityQueue;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        // 시작 시간 순으로 정렬
        PriorityQueue<RemainSubject> pq = new PriorityQueue<>((o1, o2) -> 
            o1.getStartTime() - o2.getStartTime()
        );
        
        for(String[] s : plans) {
            pq.add(new RemainSubject(s[2], s[0], s[1]));
        }
        
        Stack<RemainSubject> stack = new Stack<>();
        
        int startIndex = 0;
        while(pq.size() > 1) {
            RemainSubject currentSubject = pq.poll();
            RemainSubject nextSubject = pq.peek();
            
            if(currentSubject.getEndTime() > nextSubject.getStartTime()) { // (시작 시간 + 과제 시간) > 다음 과제 시작 시간 이면
                // 과목명과 (과제 시간 - (다음 시작 시간 - 시작시간))  스택에 저장
                currentSubject.minusMin(nextSubject.getStartTime() - currentSubject.getStartTime());
                stack.push(currentSubject);
            } else { // 아니면 
                // 과목명 answer 저장
                answer[startIndex++] = currentSubject.getSubjectName();
                
                
                int freeTime = nextSubject.getStartTime() - currentSubject.getEndTime(); // (다음 과제 시작 시간 - 현재 과제 마무리 시간)
                while(!stack.isEmpty()) {
                    if(stack.peek().getPlayTime() <= freeTime) { // 스택의 top에 남은 과제 시간  <= freeTime 면
                        // 스택의 top에 남은 과제 시간  > freeTime 달성하거나 스택이 빌때까지 스택에 있는 과목 답에 넣기
                        freeTime -= stack.peek().getPlayTime();
                        answer[startIndex++] = stack.pop().getSubjectName();    
                    } else { // 아니면
                        // 스택의 top에 남은 과제시간 - freeTime
                        stack.peek().minusMin(freeTime);
                        break;
                    }
                }
            }
        }
        
        // pq에 남아있는 마지막 과목을 답에 넣고 stack에 값이 있으면 해당 과목도 답에 추가
        answer[startIndex++] = pq.poll().getSubjectName();
        while(!stack.isEmpty()) {
            answer[startIndex++] = stack.pop().getSubjectName();
        }
            
        
                
        return answer;
    }
}

class RemainSubject {
    private int playTime;
    private String subjectName;
    private int startTime;
    private int endTime;
    
    public RemainSubject(String playTime, String subjectName, String start) {
        this.playTime = Integer.parseInt(playTime);
        this.subjectName = subjectName;
        setStartTime(start);
        setEndTime();
    }
    
    public int getPlayTime() {
        return this.playTime;
    }
    
    public String getSubjectName() {
        return this.subjectName;
    }
    
    public int getStartTime() {
        return this.startTime;
    }
    
    public int getEndTime() {
        return this.endTime;
    }
    
    public void minusMin(int min) {
        this.playTime = this.playTime - min;
    }
    
    // 시작 시간을 분단위로 변환
    public void setStartTime(String start) {
        String[] hourAndMin = start.split(":");
        this.startTime = Integer.parseInt(hourAndMin[0]) * 60 + Integer.parseInt(hourAndMin[1]);
    }
    
    public void setEndTime() {
        this.endTime = this.startTime + this.playTime;
    }
}
