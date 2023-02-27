public class 카드뭉치 {
    public static void main(String[] args) {
        // testCase1
//        String[] cards1 = {"i", "drink", "water"};
//        String[] cards2 = {"want", "to"};
//        String[] goal = {"i", "want", "to", "drink", "water"};

        // testCase2
//        String[] cards1 = {"i", "water", "drink"};
//        String[] cards2 = {"want", "to"};
//        String[] goal = {"i", "want", "to", "drink", "water"};

        // testCase3
        String[] cards1 = {"a", "b", "c"};
        String[] cards2 = {"d"};
        String[] goal = {"a", "b", "c"};

        String res = solution(cards1, cards2, goal);
        System.out.println(res);
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        for (int i = 0, p1 = 0, p2 = 0; i < goal.length; i++) {
            if (p1 < cards1.length && goal[i].equals(cards1[p1])) {
                p1++;
            } else if (p2 < cards2.length && goal[i].equals(cards2[p2])) {
                p2++;
            } else
                return "No";
        }
        return "Yes";
    }
}
