#include <iostream>
#include <vector>
using namespace std;

int solution(vector<vector<int> > land)
{
    int answer = 0;
    
    // land[i][j](j는 0~3)가 될 수 있는 최댓값을 구한다.
    // land[i][j]가 될 수 있는 최댓값은 land[i - 1]행의 최댓값이면서 land[i][j]와 다른 열
    for(int i = 1; i < land.size(); i++)
    {
        for(int j = 0; j < 4; j++)
        {
            int max = 0;
            // land[i - 1] 행의 최댓값
            for(int k = 0; k < 4; k++)
            {
                if( k == j) continue;
                if(land[i - 1][k] > max)
                {
                    max = land[i - 1][k];
                }
            }
            // land[i - 1] 행의 최댓값을 land[i] 행에 더해준다.
            land[i][j] += max;
        }
    }
    
    // 결과적으로 마지막 열의 최댓값이 답이 된다.
    for(int i = 0; i < 4; i++)
    {
        if(answer < land[land.size()- 1][i])
        {
            answer = land[land.size() - 1][i];
        }
    }
    return answer;
}