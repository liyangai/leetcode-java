package middle;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrder54 {
	   public List<Integer> spiralOrder(int[][] matrix) {
	         List<Integer> re = new LinkedList<>();
	        if(matrix.length == 0) return re;
	        if(matrix[0].length == 0) return re;
	        int xMax = matrix[0].length -1;
	        int xMin = 0;
	        int yMax = matrix.length -1 ;
	        int yMin = 0;
	        int allSize = (xMax+1)*(yMax+1);
	        int x = 0 ;int y = 0;
	        String dir = "toRight";
	        while(re.size()<allSize){
	        	re.add(matrix[y][x]);
	        	if(dir.equals("toRight")){
	        		if(x == xMax){
	        			dir = "toBottom";
	                    y++;
	        		}else{
	        			x++;
	        		}
	        	}else if(dir.equals("toBottom")){
	        		;
	        		if(y== yMax){
	        			dir = "toLeft";
	                    x --;
	        		}else{
	        			y++;
	        		}
	        	}else if(dir.equals("toLeft")){
	        		if(x == xMin){
	        			dir = "toTop";
	                    y--;
	        		}else{
	        			x --;
	        		}
	        	}else if(dir.equals("toTop")){
	        		if(y == yMin+1){
	        			dir = "toRight";
	                    x++;
	        			xMin ++;
	        			yMin ++;
	        			xMax --;
	        			yMax --;
	        			
	        		}else {
	        			y--;
	        		}
	        	}
	        }
	        return re;
	    }
}
