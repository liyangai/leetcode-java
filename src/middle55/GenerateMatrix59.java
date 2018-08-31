package middle55;

public class GenerateMatrix59 {
    public int[][] generateMatrix(int n) {
    	int[][] re = new int[n][n];
    	int xMax = n -1;
        int xMin = 0;
        int yMax =n -1 ;
        int yMin = 0;
        int x = 0 ;int y = 0;
        String dir = "toRight";
        for(int i = 1;i<=n*n;i++){
        	re[y][x] = i;
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
