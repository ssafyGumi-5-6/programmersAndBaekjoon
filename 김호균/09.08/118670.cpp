#include <string>
#include <vector>
#include <deque>
#include <iostream>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> rc, vector<string> operations) {
    int row_size = rc.size() - 1;
    int col_size = rc[0].size() - 1;
    deque<int> left, right;
    deque<deque<int>> mid;

    for(int i = 0; i <= row_size; i++)
    {
        left.push_back(rc[i][0]);
        right.push_back(rc[i][col_size]);
    }

    for(int i = 0; i <= row_size; i++)
    {
        deque<int> tmp;
        for(int j = 1, size = col_size - 1; j <= size; j++)
        {
            tmp.push_back(rc[i][j]);
        }
        mid.push_back(tmp);
    }
    
    for(string s : operations)
    {
        if(s == "ShiftRow")
        {
           mid.push_front(mid.back());
           mid.pop_back();
           left.push_front(left.back());
           left.pop_back();
           right.push_front(right.back());
           right.pop_back();
        }
        else
        {
            if(col_size == 1)
            {
                left.push_back(right.back());
                right.pop_back();
                right.push_front(left.front());
                left.pop_front();
            }
            else
            {
                mid.front().push_front(left.front());
                left.pop_front();
                right.push_front(mid.front().back());
                mid.front().pop_back();
                mid.back().push_back(right.back());
                right.pop_back();
                left.push_back(mid.back().front());
                mid.back().pop_front();
            }
        }
    }

    vector<vector<int>> answer(row_size + 1, vector<int>(col_size + 1));

    for(int i = 0; i <= row_size; i++)
    {
        answer[i][0] = left.front();
        left.pop_front();
        answer[i][col_size] = right.front();
        right.pop_front();

        for(int j = 1, size = col_size - 1; j <= size; j++)
        {
            answer[i][j] = mid[i].front();
            mid[i].pop_front();
        }
    }

    return answer;
}