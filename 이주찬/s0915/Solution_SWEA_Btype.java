import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	private final static int CMD_INIT       = 100;
	private final static int CMD_INSERT     = 200;
	private final static int CMD_MOVECURSOR = 300;
	private final static int CMD_COUNT      = 400;
	
	private final static UserSolution usersolution = new UserSolution();
	
	private static void String2Char(char[] buf, String str, int maxLen)
	{
		for (int k = 0; k < str.length(); k++)
			buf[k] = str.charAt(k);
			
		for (int k = str.length(); k <= maxLen; k++)
			buf[k] = '\0';
	}
	
	private static char[] mStr = new char[90001];
	
	private static boolean run(BufferedReader br) throws Exception
	{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int queryCnt = Integer.parseInt(st.nextToken());
		boolean correct = false;
		
		for (int q = 0; q < queryCnt; q++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == CMD_INIT)
			{
				int H = Integer.parseInt(st.nextToken());
				int W = Integer.parseInt(st.nextToken());
				
				String2Char(mStr, st.nextToken(), 90000);
				
				usersolution.init(H, W, mStr);
				correct = true;
			}
			else if (cmd == CMD_INSERT)
			{
				char mChar = st.nextToken().charAt(0);
				
				usersolution.insert(mChar);
			}
			else if (cmd == CMD_MOVECURSOR)
			{
				int mRow = Integer.parseInt(st.nextToken());
				int mCol = Integer.parseInt(st.nextToken());
				
				char ret = usersolution.moveCursor(mRow, mCol);
				
				char ans = st.nextToken().charAt(0);
				if (ret != ans)
				{
					correct = false;
				}
			}
			else if (cmd == CMD_COUNT)
			{
				char mChar = st.nextToken().charAt(0);
				
				int ret = usersolution.countCharacter(mChar);
				
				int ans = Integer.parseInt(st.nextToken());
				if (ret != ans)
				{
					correct = false;
				}
			}
		}
		return correct;
	}

	public static void main(String[] args) throws Exception
	{
		int TC, MARK;
		
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		TC = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());
		
		for (int testcase = 1; testcase <= TC; ++testcase)
		{
			int score = run(br) ? MARK : 0;
			
			System.out.println("#" + testcase + " " + score);
		}
		
		br.close();
	}
}

class UserSolution {
    int H, W;
    char[] memo;
    int size;
    int x;
	void init(int H, int W, char mStr[])
	{
		this.H = H;
        this.W = W;
        memo = new char[H * W];
        int i = 0;
        while (mStr[i] != '\0') {
            memo[i] = mStr[i];
            i++;
        }
        size = i;
        x = toOneDimension(H, W);
	}
	
	void insert(char mChar)
	{
        for(int i = size - 1; i > x; i--) {
        	memo[i] = memo[i - 1];
        }
        memo[x] = mChar;
        x++;
        size++;
	}

	char moveCursor(int mRow, int mCol)
	{
       	int place = toOneDimension(mRow, mCol);
        if((mRow == H && mCol == W) || place >= size) {
            x = size - 1;
			return '$';
        }
        x = place;
        return memo[x];
	}

	int countCharacter(char mChar)
	{
        int cnt = 0;
        for(int i = x; i < size; i++) {
           if(memo[i] == mChar) cnt++;
        }
		return cnt;
	}
    
    int toOneDimension(int h, int w) {
    	return (h - 1) * W + w - 1;    
    }
}