#include <cmath>

using namespace std;

long long solution(int k, int d)
{
    long long answer = 0;
    
    for(int i = 0; i <= d; i += k)
    {
        long long hypotenuse = static_cast<long long>(d) * d;
        long long base = static_cast<long long>(i) * i;
        // d를 빗변으로 i를 밑변으로 생각하고 피타고라스 정리를 이용해 최대 높이를 구한 후 k로 나눈다.
        // +1 은 y가 0인 경우를 생각해서 더해준다.
        answer += static_cast<long long>(sqrt(hypotenuse - base)) / k + 1;
    }
    
    
    return answer;
}