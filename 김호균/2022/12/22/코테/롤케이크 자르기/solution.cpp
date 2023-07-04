#include <vector>
#include <set>

using namespace std;

int solution(vector<int> topping) {
    int topping_count[10001] = {0, }; // 토핑 종류 별 갯수
    int topping_type = 0; // 토핑 종류
    /*
     * 초기 작업
     * 토핑 종류와 종류 별 갯수를 구한다.
     */
    for(int i : topping)
    {
        if(topping_count[i] == 0) topping_type++; // 처음 등장한 토핑이므로 종류를 늘린다.
        topping_count[i]++;
    }
    
    int answer = 0; 
    set<int> piece; // 자른 조각에 들어가는 토핑 종류, 중복 방지를 위해 set을 사용한다.
    // 하나씩 자르는 위치를 늘려가며 토핑 종류를 확인해 답을 구한다.
    for(int i : topping)
    {
        topping_count[i]--;
        piece.insert(i);
        if(topping_count[i] == 0) topping_type--; // 갯수가 0이면 잘린 조각에만 토핑이 있는 것이므로 종류를 하나 빼준다.
        if(piece.size() == topping_type) answer++; // 자른 조각에 들어있는 토핑 종류와 남은 조각의 토핑 종류가 같으면 답을 1증가한다.
        if(piece.size() > topping_type) break;
        
    }
    
    return answer;
}