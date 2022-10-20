#include <string>
#include <vector>

using namespace std;
vector<bool> visited;
void dfs(int start, int n, vector<vector<int>> computers);
int solution(int n, vector<vector<int>> computers)
{
    int answer = n;
    visited.resize(n);
    for (int i = 0; i < n; i++)
    {
        if (visited[i])
        {
            answer--;
            continue;
        }
        dfs(i, n, computers);
    }
    return answer;
}

void dfs(int start, int n, vector<vector<int>> computers)
{
    visited[start] = true;

    for (int i = 0; i < n; i++)
    {
        if (visited[i] || computers[start][i] == 0)
            continue;
        dfs(i, n, computers);
    }
}