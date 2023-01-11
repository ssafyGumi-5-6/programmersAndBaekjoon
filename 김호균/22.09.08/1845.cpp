#include <vector>
#include <set>

using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    int size = nums.size() / 2;
    set<int> pokemon;
    for (int i : nums)
    {
        pokemon.insert(i);
    }
    answer = pokemon.size() >= size ? size : pokemon.size();
    return answer;
}