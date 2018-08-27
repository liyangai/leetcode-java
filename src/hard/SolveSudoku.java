package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SolveSudoku {
	private char[][] result;
	public void solveSudoku(char[][] board) {
		List<Character>[] initalSets = new ArrayList[9];
		for(int i = 0;i<9;i++){
			initalSets[i] = new ArrayList<>();
			initalSets[i].add('1');
			initalSets[i].add('2');
			initalSets[i].add('3');
			initalSets[i].add('4');
			initalSets[i].add('5');
			initalSets[i].add('6');
			initalSets[i].add('7');
			initalSets[i].add('8');
			initalSets[i].add('9');
		}
		
		for(int i = 0;i<9;i++){
			for(int j = 0;j<9;j++){
				char a = board[j][i];
				if(a!='.'&&initalSets[i].contains(a)){
					int x = initalSets[i].indexOf(a);
					initalSets[i].remove(x);
				}
			}
		}
		
		def(board,initalSets,0);
		board = result;
	}
	

	
	public void def(char[][] board, List<Character>[] initalSets,int index){
		
		
			ref(board,initalSets,initalSets[index],0,new ArrayList<Integer>(),index);
	
		
	}
	
	
	private void ref(char[][] board,List<Character>[] initalSets, List<Character> charList, int it,
			ArrayList<Integer> usedIndex,int rowIndex) {
			if(it==charList.size()){  //rowIndex 行所有的空格都填完了
				if(rowIndex == 9){
					result = board;
					return; 
				}
				def(board,initalSets,rowIndex+1);
				
				return;
			}
			
			for(int i = 0;i<charList.size();i++){
				if(!usedIndex.contains(i)){
					ArrayList<Integer> list = new ArrayList<>(usedIndex);
					usedIndex.add(i);
					char[][] newBoard = copyChar(board);
					addToBoard(newBoard[rowIndex],charList.get(i));
					if(!isValidSudoku(newBoard)){ //不符合就不往下了
						continue;
					}
					ref(newBoard,initalSets,charList,it+1,list,rowIndex);
				}
			}
		
	}



	private void addToBoard(char[] cs, Character character) {
		for(int i = 0;i<cs.length;i++){
			if(cs[i]=='.'){
				cs[i] = character;
				return ;
			}
		}
		
	}



	private char[][] copyChar(char[][] chs){
		char[][] c =  new char[9][9];
		for(int i = 0;i<9;i++){
			for(int j = 0;j<9;j++){
				c[i][j] = chs[i][j];
			}
		}
		return c;
	}
	

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
				int rowIndex = i;
				int columnIndex = j;
				if (i % 3 == 0) {
					if (j >= 3 && j <= 5) {
						rowIndex = i + 1;
						columnIndex = j - 3;
					}
					if (j >= 6 && j <= 8) {
						rowIndex = i + 2;
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
	
	}
}
