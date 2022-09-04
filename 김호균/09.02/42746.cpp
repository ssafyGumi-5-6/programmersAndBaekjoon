#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(int o1, int o2)
{
  string str1 = to_string(o1);
  string str2 = to_string(o2);
  return str1 + str2 > str2 + str1;
}

string solution(vector<int> numbers)
{
  string answer = "";
  sort(numbers.begin(), numbers.end(), compare);

  if (numbers[0] > 0)
  {
    for (int number : numbers)
    {
      answer += to_string(number);
    }
  }
  else
  {
    answer = "0";
  }
  return answer;
}