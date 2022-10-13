class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        if(stations[0] - w - 1 >= 1) {
            int stationCount = stations[0] - w - 1;
            answer += stationCount % (2 * w + 1) > 0 ? stationCount / (2 * w + 1) + 1 : stationCount / (2 * w + 1);
        }
        for(int i = 0, length = stations.length - 1; i < length; i++) {
            int stationCount = (stations[i + 1] - w) - (stations[i] + w);
            if( stationCount > 1) {
                stationCount--;
                answer += stationCount % (2 * w + 1) > 0 ? stationCount / (2 * w + 1) + 1 : stationCount / (2 * w + 1);
            }
        }
        
        if(stations[stations.length - 1] + w <= n) {
            int stationCount = (n - (stations[stations.length - 1] + w));
            answer += stationCount % (2 * w + 1) > 0 ? stationCount / (2 * w + 1) + 1 : stationCount / (2 * w + 1);
        }
        return answer;
    }
}