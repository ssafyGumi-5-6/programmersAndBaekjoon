import java.util.Arrays;

// 정렬하고
// 첫번째 데이터의 끝데이터는 무조건 들어가고 (answer=1)
// 첫번째 데이터의 끝 데이터를 기준으로 이것보다 작은 애들은 통과
// 큰애가 나오면 answer+=1 그리고 기준데이터는 새로 나온 큰애의 끝데이터가 됨
// routes의 끝가지 가서 answer가 몇인지 출력

class Solution {
	public int solution(int[][] routes) {
		Arrays.sort(routes, (o1, o2) -> {return o1[1] - o2[1];});
		int standard = routes[0][1];
		int answer = 1;
		for (int i = 1; i < routes.length; i++) {
			if (routes[i][0] <= standard) continue;
			answer += 1;
			standard = routes[i][1];	
		}
		System.out.println(answer);
		return answer;
    }
	public static void main(String[] args) {
//		new Solution().solution(new int [] [] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}});
		new Solution().solution(new int [] [] { {-191, -107}, { -184,-151 }, { -150,-102 }, { -171,-124 }, { -120,-114 } } );
	}
}