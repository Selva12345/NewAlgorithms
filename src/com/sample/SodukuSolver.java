package com.sample;

public class SodukuSolver {
	public static void main(String[] args) {
		SodukuSolver s=new SodukuSolver();
char sod[][]={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
s.solveSudoku(sod);

	}

	public void solveSudoku(char[][] board) {
		int n = board.length;
		int m = board[0].length;
		justDoIt(board, n, m, 0, 0);
		System.out.println();
	}

	private boolean justDoIt(char[][] board, int n, int m, int i, int j) {
		if(i>=n) {
			return true;
		}
		if (i >= n && j >= m) {
			return true;
		}
		
		if (i < n && j < m && board[i][j] != '.') {
			if (justDoIt(board, n, m, i, j + 1))
				return true;
		} else if (j < m && i < n) {
			for (char k = '1'; k <= '9'; k++) {
				if (j < m && i < n) {
					if (isValidRow(k, board, i) && isValidColumn(k, board, j) && isValid(k, board, i, j)) {
						if(board[0][2]=='4'&&board[0][3]=='6'&&board[0][5]=='8'&&board[0][6]=='9')
							System.out.println(i + " " + j);
						board[i][j] = k;
						if (justDoIt(board, n, m, i, j + 1))
							return true;
						board[i][j] = '.';
					}

				}
			}
		} else if (i < n && j >= m) {
			if (justDoIt(board, n, m, i + 1, 0))
				return true;
		}

		return false;
	}

	private boolean isValidRow(char val, char[][] board, int i) {
		for (int j = 0; j < board[0].length; j++) {
			if (val == board[i][j])
				return false;
		}
		return true;
	}

	private boolean isValidColumn(char val, char[][] board, int j) {
		for (int i = 0; i < board.length; i++) {
			if (val == board[i][j])
				return false;
		}
		return true;
	}

	private boolean isValid(char val, char[][] board, int i, int j) {
		if (i < 3)
			i = 0;
		if (i >= 3 && i < 6)
			i = 3;
		if (i >= 6 && i < 9)
			i = 6;
		if (j < 3)
			j = 0;
		if (j >= 3 && j < 6)
			j = 3;
		if (j >= 6 && j < 9)
			j = 6;
		for (int p = i; p < i + 3; p++) {
			for (int q = j; q < j + 3; q++) {
				if (val == board[p][q])
					return false;
			}
		}
		return true;
	}

}
