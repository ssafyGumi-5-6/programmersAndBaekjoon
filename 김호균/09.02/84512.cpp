#include <string>
#include <vector>
#include <set>
using namespace std;

int result = 0;
set<string> setString;
string str[6] = {"", "A", "E", "I", "O", "U"};
void perm(int cnt, int start, string dic);
int solution(string word)
{
  int answer = 0;
  perm(0, 1, "");
  for (string s : setString)
  {
    answer++;
    if (s == word)
    {
      break;
    }
  }
  return answer;
}
void perm(int cnt, int start, string dic)
{
  if (cnt == 5)
  {
    setString.insert(dic);
    return;
  }

  for (int i = start; i < 6; i++)
  {
    perm(cnt + 1, 0, dic + str[i]);
  }
}