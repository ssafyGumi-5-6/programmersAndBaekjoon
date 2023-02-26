package 카드뭉치;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int cardIdx1 = 0;
        int cardIdx2 = 0;


        if(cards1.length + cards2.length < goal.length){
            answer = "No";
            return answer;
        }


        for(String g : goal){
            boolean check = false;
            // System.out.println("g : " + g);
            // card1
            for(int idx = cardIdx1; idx < cards1.length; idx++){
                // System.out.println("card1 : " + cards1[idx]);
                if(cards1[idx].equals(g)){
                    cardIdx1 = idx + 1;
                    check = true;
                    break;
                }
            }

            // card2
            if(!check){
                for(int idx = cardIdx2; idx < cards2.length; idx++){
                    // System.out.println("card2 : " + cards2[idx]);
                    if(cards2[idx].equals(g)){
                        cardIdx2 = idx + 1;
                        check = true;
                        break;
                    }
                }
            }

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