#include <string>
#include <vector>
#include <deque>
#include <iostream>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> rc, vector<string> operations)
{
    int row_size = rc.size() - 1;
    int col_size = rc[0].size() - 1;
    deque<int> left, right;
    deque<deque<int>> mid;

    for (int i = 0; i <= row_size; i++)
    {
        left.emplace_back(rc[i][0]);
        right.emplace_back(rc[i][col_size]);

        deque<int> tmp;
        for (int j = 1, size = col_size - 1; j <= size; j++)
        {
            tmp.emplace_back(rc[i][j]);
        }
        mid.emplace_back(tmp);
    }

    for (string s : operations)
    {
        if (s == "ShiftRow")
        {
            mid.emplace_front(mid.back());
            mid.pop_back();
            left.emplace_front(left.back());
            left.pop_back();
            right.emplace_front(right.back());
            right.pop_back();
        }
        else
        {
            if (col_size == 1)
            {
                left.emplace_back(right.back());
                right.pop_back();
                right.emplace_front(left.front());
                left.pop_front();
            }
            else
            {
                mid_front.emplace_front(left.front());
                left.pop_front();
                right.emplace_front(mid_front.back());
                mid_front.pop_back();
                mid_back.emplace_back(right.back());
                right.pop_back();
                left.emplace_back(mid_back.front());
                mid_back.pop_front();
            }
        }
    }

    vector<vector<int>> answer;

    for (int i = 0; i <= row_size; i++)
    {
        vector<int> temp;
        temp.emplace_back(left.front());
        left.pop_front();

        for (int j = 1, size = col_size - 1; j <= size; j++)
        {
            temp.emplace_back(mid[i].front());
            mid[i].pop_front();
        }

        temp.emplace_back(right.front());
        right.pop_front();
        answer.emplace_back(temp);
    }

    return answer;
}