package Solution2;
import java.util.*;


//// 우선순위 큐
//// 5, 6, 7, 8 시간 초과
//class Node implements Comparable<Node>{
//    long curTime;
//    int waitingTime;
//
//    Node(long curTime, int waitingTime){
//        this.curTime = curTime;
//        this.waitingTime = waitingTime;
//    }
//
//    @Override
//    public int compareTo(Node n){
//        return (int)(this.curTime - n.curTime);
//    }
//}
//
//class Solution {
//    public long Solution(int n, int[] times) {
//        long answer = 0;
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//
//        // 다음 심사가능시간, 심사 대기시간
//        // 7, 10 => 7 10 14 20 21
//        for(int i = 0; i < times.length; i++) pq.add(new Node(times[i], times[i]));
//
//        for(int i = 0; i < n; i++){
//            Node curNode = pq.poll();
//            if(i == n - 1) answer = curNode.curTime;
//            else pq.add(new Node(curNode.curTime + curNode.waitingTime, curNode.waitingTime));
//        }
//        return answer;
//    }
//}



// 이분 탐색 : https://ljw538.tistory.com/85 (참고)
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        // 최악의 경우, times에서 가장 큰 값 x n번 횟수
        long max = 1;
        for(int i =0; i< times.length; i++) max = Math.max(max, times[i]);
        long right = n * max;


        while(left <= right){
            // System.out.println("left, right : " + left + " " + right);
            long mid = (left + right) / 2;
            // System.out.println("mid : " + mid);
            long temp = n;
            for(int i = 0; i < times.length; i++){
                temp -= mid / times[i];
                // 만약 temp가 0보다 작거나 같을 경우 현재 위치가 심사를 받는데 걸리는 시간
                if(temp <= 0){
                    answer = mid;
                    right = mid - 1;
                }
            }
            // 만약 temp가 0보다 크다면 현재 위치는 모든 사람이 심사를 받는데 부족하다.
            if(temp > 0) left = mid + 1;
        }

        return answer;
    }
}