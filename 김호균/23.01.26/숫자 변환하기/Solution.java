# [L2] **숫자 변환하기 - 154538**

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/154538)

### 회고

1000000도 포함해서 확인을 했어야하는데 그걸 놓쳐 찾는데 오래걸렸다.

### 코드

```java
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        
        // 중복되는 숫자로 인한 메모리 초과를 방지하기 위한 Set
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()) {
            int size = q.size();
            while(--size >= 0) {
                x = q.poll();
                if(set.contains(x)) continue;
                set.add(x);
                
                if(x == y) return answer;
                
                // 1,000,000을 넘어가면 의미가 없으므로 제한을 둔다.
                if(x + n <= 1000000) {
                    q.offer(x + n);
                }
            
                if(x * 2 <= 1000000) {
                    q.offer(x * 2);
                }
            
                if(x * 3 <= 1000000) {
                    q.offer(x * 3);
                }  
            }
            answer++;
        }
        if(x != y) return -1;
        return answer;
    }
}
```
