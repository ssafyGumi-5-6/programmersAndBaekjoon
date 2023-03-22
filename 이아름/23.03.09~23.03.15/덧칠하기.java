import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] checked = new boolean[n+1];
        
        for(int i:section){
            checked[i] = true;
        
        }
        for(int i = 1,sec = 0; i <= n; i++){
            if(checked[i]){
                int index = i;
                int j = 0;
                while(index + j <= n && j < m){
                    checked[index + j] = false;
                    j++;
                }
                answer++;
            }
        }
        return answer;
    }
}