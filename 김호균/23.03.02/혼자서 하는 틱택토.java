class Solution {
    public int solution(String[] board) {
        boolean oWin = false, xWin = false;
        int OminusX = 0;
        for(int i = 0; i < board.length; i++) {
            int oColumnCount = 0, xColumnCount = 0;
            
            for(int j = 0; j < board[0].length(); j++) {
                // 열 검사
                if(board[j].charAt(i) == 'O') {
                    oColumnCount++;
                    OminusX++; 
                } else if(board[j].charAt(i) == 'X') {
                    xColumnCount++;
                    OminusX--;
                }  
            }
            
            if(oColumnCount == 3) oWin = true;
            if(xColumnCount == 3) xWin = true;
            
            // 행 검사
            if(board[i].equals("OOO")) 
                oWin = true;
            
            if(board[i].equals("XXX")) 
                xWin = true;
        }

        // 대각선
        if((board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O')
          || (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O'))
            oWin = true;
        
        if((board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X')
          || (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X'))
            xWin = true;
        
        
        if(oWin && !xWin && OminusX == 1) return 1;
        else if(!oWin && xWin && OminusX == 0) return 1;
        else if(!oWin && !xWin && (OminusX == 1 || OminusX == 0)) return 1;
        return 0;
    }
}
