package hard;

public class RgisMatch {
	private String str;
	private String par;
	public boolean isMatch(String s, String p) {
		this.str = s;
		this.par= p;
		if(s.equals(p)){
			return false;
		}
		if(p.equals("")){
			return false;
		}
		return match(0,0);
	}
	
	private boolean match(int index1,int index2){
		int len1 = str.length();
		int len2 = par.length();
		boolean index1End = index1>= len1;
		boolean index2End = index2 >= len2;
		if(index1End && index2End) return true;
		if(!index1End && index2End) return false;
		if(index2<len2-1 && par.charAt(index2)+1=='*'){
			if(str.charAt(index1)==par.charAt(index2) || par.charAt(index2) == '.'){  //ÄÜÆ¥Åä
				return match(index1,index2+2) || match(index1+1,index2);
			}else{  
				return match(index1,index2+2);
			}
		}
		if(!index2End && index1End){
			return false;
		}
		
		if(str.charAt(index1)==par.charAt(index2) || par.charAt(index2) == '.'){ //ÄÜÆ¥Åä
			return match(index1+1,index2+1); 
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		
	}
}
