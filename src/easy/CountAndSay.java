package easy;

public class CountAndSay {
	public String countAndSay(int n) {
        String start = "1";
        int i = 0;
        while(i<n-1){
        	int len = start.length();
        	String s = "";
        	char st = start.charAt(0);
            int startIndex = 0;
         	for(int j = 0;j<len;j++){
         		if(start.charAt(j)!=st){
                    s += (j-startIndex); 
                    s += start.charAt(startIndex);
                    st = start.charAt(j);
                    startIndex = j;
                 }
         		
         		if(j==len-1){
         			 s += (j-startIndex+1); 
                     s += start.charAt(startIndex);
         		}
         	
         	}
        	start = s;
        	i++;
        }
        return start;
    }
	public static void main(String[] args) {
		CountAndSay test = new CountAndSay();
		test.countAndSay(4);
	}

}
