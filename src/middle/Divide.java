package middle;

public class Divide {
	 public int divide(int dividend, int divisor) {
		
		 
	     if(dividend == 0) return 0;
	     if(divisor == 1) return dividend;
	     if(dividend == Integer.MIN_VALUE && divisor == -1){
	    	 return Integer.MAX_VALUE;
	     }
		 if(divisor == -1) return -dividend;
		 boolean isResponsive;
		  
		 if(dividend<0){
			 dividend = - dividend;
			 if(divisor<0){
				 isResponsive = true;
				 divisor = -divisor;
			 }else{
				 isResponsive = false;
			 }
		 }else{
			 if(divisor< 0){
				 divisor = - divisor;
				 isResponsive = false;
			 }else{
				 isResponsive = true;
			 }
		 }
		 if(dividend<divisor){
			 return 0;
		 }
		 
		 
		 long divid = (long)dividend;
		 long divis = (long)divisor;
		 
		 long last = divid;
		 long i = 0;
		 while(last>=divis){
			 i++;
			 last = last - divis;
		 }
		 if(!isResponsive){
			 i = -i;
		 }
		 return (int)i;
		 
	 }
	 
	 public static void main(String[] args) {
//		 Divide test = new Divide();
//		 test.divide(10,3);
		 int i = 12;
		 i <<=4;
		 int b = (int) (12 *(Math.pow(2, 4)));
		 System.out.println(i);
		 System.out.println(b);
	}
}
