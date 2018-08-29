package middle;

public class MyPow50 {
	public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n<0) return 1/pow(x, -n);
        return pow(x,n);
        
    }
	private double pow (double x ,int n){
		 	if(n == 1) return x;
	        
	        int half = n >> 1;
	        if(n%2 == 0) return myPow(x,half) * myPow(x,half);
	        else  return myPow(x,half) * myPow(x,half) * x;
	}
	
	public static void main(String[] args) {
		int i = 11;
		int b = i >>1;
		System.out.println(b);
	}
}
