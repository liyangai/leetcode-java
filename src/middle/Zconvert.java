package middle;

public class Zconvert {
	public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] resultArray = new StringBuilder[numRows];
        for(int k = 0 ;k<numRows;k++){
        	resultArray[k] = new StringBuilder(); 
        }
        int len = s.length();
        int convert = 1;
        int dir = 0;
        for(int i = 0 ;i<len;i++){
        	resultArray[dir].append(s.charAt(i));
        	dir = dir + convert*(1);
        	if(dir == numRows -1) convert = -1;
        	if(dir == 0) convert = 1;
        }
        StringBuilder re = new StringBuilder();
        for(int j = 0;j<numRows;j++){
        	re.append(resultArray[j]);
        }
        return re.toString();
        
    }
	
	 public int reverse(int x) {
	        int rev = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            x /= 10;
	            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
	            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
	            rev = rev * 10 + pop;
	        }
	        return rev;
	    }
	
	public static void main(String[] args) {
		Zconvert test  = new Zconvert();
//		String s = "PAYPALISHIRING";
//		int numRows = 3;
//		System.out.println(test.convert(s, numRows));
		int x = 2652;
		test.reverse(2652);
	}
}
