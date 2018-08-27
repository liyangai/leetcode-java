package middle;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Rotateimage48 {
	  public void rotate(int[][] matrix) {
		  int len = matrix.length;
		  int start = 0;
		  int end = len-1;
		  while(start<end){
			  rotateSingle(start,end,matrix);
			  start ++ ;
			  end--;
		  }
	  }

	private void rotateSingle(int start,int end, int[][] matrix) {
		Queue<Integer> topQ = new LinkedList<>();
		
		for(int i = start;i<=end;i++){
			topQ.offer(matrix[start][i]);
		}
		
		for(int i = start,j = end;i<=end;i++,j--){
			matrix[start][i] = matrix[j][start];
		}
		for(int i = start;i<=end;i++){
			matrix[i][start] = matrix[end][i];
		}
		for(int i = start,j = end;i<=end;i++,j--){
			matrix[end][i] = matrix[j][end];
		}
		
		for(int i = start;i<=end;i++){
			matrix[i][end] = topQ.poll();
		}
		
	}
}
