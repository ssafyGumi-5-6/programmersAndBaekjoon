package y2023.s0301;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<ComparableTest> testList = new ArrayList<ComparableTest>();
        for (int i = 0, j = 20; i < 10; i++, j--) {
            ComparableTest c = new ComparableTest();
            c.T = i;
            c.E = j;
            testList.add(c);
        }
        System.out.println(testList);
        Collections.sort(testList);
        System.out.println(testList);
    }
}

class ComparableTest implements Comparable<ComparableTest> {
    int T;
    int E;
    int S;
    @Override
    public int compareTo(ComparableTest o) {
        return o.T - this.T; // 비교 대상이 더 클 경우(내가 작을 경우) 양수 리턴 : 내림차순
    }
    @Override
    public String toString() {
        return "[T:" + this.T + " E:" + this.E + " S:" + this.S + "]";
    }

}