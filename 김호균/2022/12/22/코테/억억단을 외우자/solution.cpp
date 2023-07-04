#include <vector>
#include <iostream>

using namespace std;
/*
 * 초기에 약수 구하는 공식을 아래와 같이 작성했지만
 * 아래 공식을 이용하면 1~500만까지 연산했을 때 74억 가까운 연산량을 보여
 * 시간 초과가 발생했다.
 */
int get_divisor_count(int n)
{
    int count = 0;
    for(int i = 1; i * i <= n; i++)
        {
            if(n % i == 0)
            {
                count++;
                if(i * i < n)
                    count++;   
            }
        }
    return count + 2;
}

vector<int> solution(int e, vector<int> starts) {
    vector<int> divisor_count(e + 1, 1); // 약수 갯수 저장, 1단에서 항상 등장하므로 1로 초기화한다.
    vector<int> max_divisor(e + 1); // n~e 까지 중 약수가 가장 많은 수 저장
    
    for(int i = 2; i <= e; i++)
         // i 배수들의 약수 개수를 전부 증가한다.
        for(int j = 1; j <= (e / i); j++)
            divisor_count[i * j]++;
    
    
    max_divisor[e] = e;
    for(int i = e - 1; i >= 1; i--)
    {
        /*
         * 기존에 약수 개수가 가장 많은 수의 약수 보다 i의 약수 갯수가 더 많으면
         * max_divisor[i]의 값을 i로 저장한다.
         * 더 적으면 기존 값을 max_divisor[i]에 저장한다.
         */
        if(divisor_count[max_divisor[i + 1]] <= divisor_count[i])
            max_divisor[i] = i;
        else
            max_divisor[i] = max_divisor[i + 1];
    }
    
    vector<int> answer(starts.size());
    //max_divisor[x]의 값은 x ~ e 중에 약수의 갯수가 가장 많으면서 크기는 작은 수를 나타낸다.
    for(int i = 0; i < starts.size(); i++)
        answer[i] = max_divisor[starts[i]];

    return answer;
}