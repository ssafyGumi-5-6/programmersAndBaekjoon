#include <vector>
#include <queue>

using namespace std;

int solution(int n, int k, vector<int> enemy) {
    
    priority_queue<int> pq;
    // 각 라운드 적을 힙에 넣어준다.
    for(int i = 0; i < enemy.size(); i++)
    {
        pq.push(-enemy[i]); // -를 붙이는 이유는 최소힙처럼 사용하기 위해서이다.
        
        /* 
         * 힙 크기가 k를 넘기면 무적권만 사용해서 막을 수 없으므로
         * 적의 수가 가장 작은 라운드의 적을 병사로 막는다.
         */
        if(pq.size() > k)
        {
            n += pq.top();
            pq.pop();
        }
        
        // n이 0보다 작아지면 해당 라운드는 못 막으므로 i를 리턴해준다.
        if(n < 0)
        {
            return i;
        }
    }
    
    // 반복문이 끝날 동안 리턴이 없었다는 것은 모두 막을 수 있음을 의미한다.
    return enemy.size();
}