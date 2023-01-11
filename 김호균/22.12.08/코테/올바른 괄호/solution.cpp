#include <string>
#include <stack>

using namespace std;

bool solution(string s)
{
    stack<char> parenthesis;
    for(int i = 0; i < s.size(); i++)
    {
        if(s[i] == ')') // 닫는 괄호일 때
        {
            /*
             * 스택이 비었으면 짝이 안 맞으므로 false 리턴
             * 스택이 안 비어있으면 스택에서 여는 괄호 하나를 제거한다.
             */
            if(parenthesis.empty())
            {
                return false;
            }
            else
            {
                parenthesis.pop();
            }
        }
        else
        {
            // 여는 괄호는 스택에 담는다.
            parenthesis.push('(');
        }
    }
    
    /*
     * 반복문을 모두 돌았을 때 스택에 괄호가 남았으면 
     * 짝이 안 맞으므로 false를 리턴한다.
     */
    if(parenthesis.empty())
        return true;
    else
        return false;
    
}