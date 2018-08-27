package middle;

public class Multiply43 {
	public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] re = new int[len1+len2];
        for(int i =len1-1;i>=0;i--){
        	for(int j = len2-1;j>=0;j--){
        		re[i+j+1] += Integer.valueOf(String.valueOf(num1.charAt(i))) * Integer.valueOf(String.valueOf(num2.charAt(j))) ;
        	}
        }
        
        int charge = 0;
        for(int i= re.length-1;i>=0;i--){
        	re[i] += charge;
        	charge = re[i]/10;
        	re[i] = re[i]%10;
        }
        String s = "";
        boolean firsZero = false;
        for(int i = 0;i<re.length;i++){
        	if(re[i]==0&&!firsZero){
        		continue;
        	}
        	
        		firsZero = true;
        	
        	   s += re[i];
        }
        
        if(s.equals("")){
        	return "0";
        }
        
        return s;
    }
	public static void main(String[] args) {
		Multiply43 test = new Multiply43();
		System.out.println(test.multiply("0", "0"));
	}
}
