#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion)
{
  string answer = "";
  unordered_map<string, int> completionMap;
  for (int i = 0; i < completion.size(); i++)
  {
    completionMap[completion[i]]++;
  }

  for (int i = 0; i < participant.size(); i++)
  {
    answer = participant[i];
    if (completionMap.count(answer) == 0)
    {
      answer = answer;
      return answer;
    }
    completionMap[answer]--;
    if (completionMap[answer] <= 0)
    {
      completionMap.erase(answer);
    }
  }
  return answer;
}