import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1 = new ArrayDeque<>();
        Long q1Sum = 0L;
        Queue<Integer> q2 = new ArrayDeque<>();
        Long q2Sum = 0L;
        // 배열을 Queue로 바꿔주면서 원소의 총합을 구해준다.
        for(int i = 0, length = queue1.length; i < length; i++) {
            q1.add(queue1[i]);
            q1Sum += queue1[i];
            q2.add(queue2[i]);
            q2Sum += queue2[i];
        }
        
        int count = 0;
        // 합의 크기가 큰 큐에서 작은 큐로 원소를 하나주고 크기를 비교한다.
        // 큐의 길이를 n이라 할 때 한 큐의 n - 1 번째 원소가 전체 합의 절반과 크기가 같은 경우
        // 3n - 3만큼의 시간이 걸린다.
        // 예시) q1 = [3, 3, 3, 3], q2 = [3, 3, 21, 3]
        for(int i = 0, length = queue1.length * 3 - 3; i <= length; i++) {
            if(q1Sum > q2Sum) {
                q1Sum -= q1.peek();
                q2Sum += q1.peek();
                q2.add(q1.poll());
                count++;
            } else if(q1Sum < q2Sum) {
                q2Sum -= q2.peek();
                q1Sum += q2.peek();
                q1.add(q2.poll());
                count++;
            } else {
                answer = count;
                break;
            }
        }
        return answer;
    }
}