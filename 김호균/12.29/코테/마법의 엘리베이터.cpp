int solution(int storey) {
    int answer = 0;
    
    while(storey != 0)
    {
        int units = storey % 10; // 1의 자리
        int tens = (storey % 100) / 10; // 10의 자리
        
        if(units < 5)
        {
            answer += units;
        }
        /*
         * 1의 자리가 5인 경우 10의 자리에 따라 올릴지 내릴지 결정한다.
         * 10의 자리가 5 이상이면 올림을 했을 때 올림수로 인해 횟수를 한 번 더 줄일 수 있고
         * 10의 자리가 5 이하면 내림해서 올림수를 만들지 않는게 이득을 본다.
         */
        else if (units == 5)
        {
            if(tens >= 5)
            {
                answer += 5;
                storey += 10; // 올림수
            }
            else
            {
                answer += 5;
            }
        }
        else
        {
            answer += 10 - units;
            storey += 10;
        }
        
        storey /= 10;
    }
    return answer;
}