#include <string>
#include <vector>

using namespace std;

void dfs(int cnt, int start, int a_score, int score, vector<int> info, vector<int> ryan_info);

vector<int> answer;
int max_diff = 0;
vector<int> solution(int n, vector<int> info) {
    int a_score = 0;
    for(int i = 0, size = info.size(); i < size; i++)
    {
        if(info[i] != 0) a_score += (10 - i);
    }
    vector<int> ryan_info(11);
    dfs(n, 0, a_score, 0, info, ryan_info);
    if(answer.size() == 0)
    {
        answer.push_back(-1);
    }
    return answer;
}

void dfs(int cnt, int start, int a_score, int score, vector<int> info, vector<int> ryan_info)
{
    if(a_score < 0)
    {
        return;
    }
    
    if(cnt == 0 || start >= 11)
    {
        if(cnt > 0)
            ryan_info[start - 1] += cnt;
        int diff = score - a_score;
        if(diff > max_diff)
        {
            max_diff = diff;
            answer = ryan_info;
        }
        if(max_diff > 0 && diff == max_diff)
        {
            for(int i = 10; i >= 0; i--)
            {
                if(answer[i] > ryan_info[i])
                {
                    break;
                }
                
                if(answer[i] < ryan_info[i])
                {
                    answer = ryan_info;
                    break;
                }
            }
        }
        return;
    }
    if(cnt - (info[start] + 1) >= 0)
    {
        ryan_info[start] = info[start] + 1;
        int cur_score = (10 - start);
        if(info[start] > 0)
        {
            dfs(cnt - ryan_info[start], start + 1, a_score - cur_score, score + cur_score, info, ryan_info);
        }
        else
        {
            dfs(cnt - ryan_info[start], start + 1, a_score, score + cur_score, info, ryan_info);  
        }
    }
    
    ryan_info[start] = 0;
    dfs(cnt, start + 1, a_score, score, info, ryan_info);
}