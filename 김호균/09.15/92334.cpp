#include <string>
#include <vector>
#include <map>
#include <set>
#include <sstream>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k)
{
    vector<int> answer(id_list.size());
    map<string, int> index;
    for (int i = 0; i < id_list.size(); i++)
    {
        index[id_list[i]] = i;
    }

    map<string, set<string>> troll;

    for (string s : report)
    {
        vector<string> split;
        string buffer;
        istringstream iss(s);
        while (getline(iss, buffer, ' '))
        {
            split.push_back(buffer);
        }

        troll[split[1]].insert(split[0]);
    }

    for (auto iter : troll)
    {
        if (iter.second.size() >= k)
        {
            for (auto in_iter : iter.second)
            {
                answer[index[in_iter]]++;
            }
        }
    }

    return answer;
}