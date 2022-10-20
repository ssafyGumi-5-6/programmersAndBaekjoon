import java.util.Arrays;

class Solution {

    static boolean checkStone(int[] stones, int mid, int k){

        int cnt = 0;
        for(int i =0; i<stones.length; i++){

            // 디딤돌이 지나간 사람 수보다 작거나 같다면 cnt + 1
            if(stones[i] <= mid) cnt += 1;
            else cnt = 0; // 디딤돌이 지나간 사람 수보다 크다면 cnt = 0;

            if(cnt ==k) return false;
        }
        return true;
    }

    public int solution(int[] stones, int k) {

        // (1) 방법 1 (x)
        // - 인원수를 한명씩 늘려가면서 찾을 경우, 효율성에서 시간초과가 발생한다. (for문 2개일 경우)
        //
        // (2) 방법 2 (o)
        // 현재 나올 수 있는 인원수를 기준으로 이분 탐색을 한다.
        // 최소 인원 수: 0명, 최대 인원 수 : 징검다리 디딤돌에 적혀있는 숫자 중 가장 큰 값
        // (최소 인원 수 + 최대 인원 수) / 2 => mid 값을 구한 후, 디딤돌에 적혀있는 숫자를 하나씩 검토하며 숫자로 센다.
        // - 검토했을 떄, 만약 k보다 크거나 같다면 end - 1로 최대인원수를 줄인다.
        // - 검토했을 떄, 만약 k보다 작다면 begin + 1로 최소인원수를 늘린다.
        // 최종으로 나온 최종인원수가 정답이 된다.


        int start = 0;
        int end =0 ;
        for(int s : stones){
            end = Math.max(end, s);
        }

        while(start <= end ){
            int mid = (start + end) / 2;
            if(checkStone(stones, mid, k)){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return start;
    }
}