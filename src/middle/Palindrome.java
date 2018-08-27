package middle;

public class Palindrome {
	 public boolean isPalindrome(int x) {
	    if(x<0||(x%10==0&&x!=0)){
	    	return false;
	    }
	    String s = String.valueOf(x);
	    int len =s.length();
	    int half = s.length()/2;
	    for(int i = 0 ; i<half;i++){
	    	if(s.charAt(i)!=s.charAt(len-1-i)){
	    		return false;
	    	}
	    }
	    return true;
	    
	}
	public static void main(String[] args) {
		Palindrome test = new Palindrome();
		System.out.println(test.isPalindrome(65121456));
	}
}
