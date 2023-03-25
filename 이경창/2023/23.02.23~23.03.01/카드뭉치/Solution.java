package 카드뭉치;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int cardIdx1 = 0;
        int cardIdx2 = 0;

        for(String g : goal){
            boolean check = false;
            // System.out.println("g : " + g);
            // card1
            if(cards1.length > cardIdx1 && cards1[cardIdx1].equals(g)){
                cardIdx1 += 1;
                check = true;
            }else if(cards2.length > cardIdx2 && cards2[cardIdx2].equals(g)){
                cardIdx2 += 1;
                check = true;
            }

            // card2
            // System.out.println("answer : " + cardIdx1 + " " + cardIdx2 + " check : " + check);
            if(!check){
                answer = "No";
                // System.out.println("answer : " + cardIdx1 + " " + cardIdx2);
                break;
            }

        }
        return answer;
    }
}