class Solution {
    public int[] solution(int[] sequence, int k) {

        int startIdx = 0;
        int sequenceSum = 0;
        int curResultLen = 0;
        int curLeftIdx = 0;
        int curRightIdx = 0;


        for(int i = 0; i < sequence.length; i++){
            sequenceSum += sequence[i];

            if(sequenceSum >= k){
                while(sequenceSum > k){
                    sequenceSum -= sequence[startIdx];
                    startIdx += 1;
                }

                if(sequenceSum == k && curResultLen == 0 && curLeftIdx == 0){
                    curResultLen = (i - startIdx) + 1;
                    curLeftIdx = startIdx;
                    curRightIdx = i;
                }else if(sequenceSum == k && curResultLen > (i - startIdx) + 1){
                    curResultLen = (i - startIdx) + 1;
                    curLeftIdx = startIdx;
                    curRightIdx = i;
                }

            }
        }
        int[] answer = {curLeftIdx, curRightIdx};
        return answer;
    }
}