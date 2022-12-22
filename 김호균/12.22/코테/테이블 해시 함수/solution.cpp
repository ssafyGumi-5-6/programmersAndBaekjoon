#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<vector<int>> data, int col, int row_begin, int row_end) {
    int answer = 0;
    // 정해진 규칙에 따라 정렬 
    sort(data.begin(), data.end(), [col](vector<int> v1, vector<int> v2) {
        if( v1[col - 1] == v2[col - 1] ) return v1[0] > v2[0];
        else return v1[col - 1] < v2[col - 1];
    });
    
    // row_begin부터 row_end까지 mod 연산 후 xor 연산
    for(int i = row_begin - 1; i < row_end; i++)
    {
        int sum = 0;
        for(int j = 0; j < data[0].size(); j++)
        {
            sum += data[i][j] % (i + 1);
        }
        answer ^= sum;
    }
    
    return answer;
}