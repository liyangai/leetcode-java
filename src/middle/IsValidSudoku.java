package middle;

import java.util.HashSet;

public class IsValidSudoku {
	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 9; i++) {
			HashSet<Character> row = new HashSet<>();
			HashSet<Character> column = new HashSet<>();
			HashSet<Character> cube = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !column.add(board[j][i]))
					return false;
				int rowIndex = 0;
				int columnIndex = 0;
				if (i % 3 == 0) {
					if (j >= 3 && j <= 5) {
						rowIndex = i + 1;
						columnIndex = j - 3;
					}
					if (j >= 6 && j <= 8) {
						rowIndex = j + 2;
						columnIndex = j - 6;
					}
				} else if (i % 3 == 1) {
					if (j >= 0 && j <= 2) {
						rowIndex = i - 1;
						columnIndex = j + 3;
					}
					if (j >= 6 && j <= 8) {
						rowIndex = i + 1;
						columnIndex = j - 3;
					}
				} else {
					if (j >= 0 && j <= 2) {
						rowIndex = i - 2;
						columnIndex = j + 6;
					}
					if (j >= 3 && j <= 5) {
						rowIndex = i - 1;
						columnIndex = j + 3;
					}
				}
				if (board[rowIndex][columnIndex] != '.' && !cube.add(board[rowIndex][columnIndex]))
					return false;

			}
		}

		return true;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> row = new HashSet<>();
			HashSet<Character> column = new HashSet<>();
			HashSet<Character> cube = new HashSet<>();
			for (int j = 0; j < 9; j++) {

				int rowIndex = i;
				int columnIndex = j;
				if (i % 3 == 0) {
					if (j >= 3 && j <= 5) {
						rowIndex = i + 1;
						columnIndex = j - 3;
					}
					if (j >= 6 && j <= 8) {
						rowIndex = j + 2;
						columnIndex = j - 6;
					}
				} else if (i % 3 == 1) {
					if (j >= 0 && j <= 2) {
						rowIndex = i - 1;
						columnIndex = j + 3;
					}
					if (j >= 6 && j <= 8) {
						rowIndex = i + 1;
						columnIndex = j - 3;
					}
				} else {
					if (j >= 0 && j <= 2) {
						rowIndex = i - 2;
						columnIndex = j + 6;
					}
					if (j >= 3 && j <= 5) {
						rowIndex = i - 1;
						columnIndex = j + 3;
					}
				}
				System.out.println(rowIndex+"  "+columnIndex);

			}
		}
	}
}