package middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateKuoHao {
	 public List<String> generateParenthesis(int n) {
	     List<String> re = new ArrayList<>();
	     List<String> ret = new ArrayList<>();
	     int length = 2*n;
	     backSource(length,0,re,"");
	     for(String s : re){
	    	 if(isVaild(s)){
	    		 ret.add(s);
	    	 }
	     }
	     return ret;
		 
	  }
	  
	 private void backSource(int length ,int index ,List<String> re ,String sb){
		 if(index == length){
			 re.add(sb);
			 return ;
		 }
		 for(int i = 0;i<2 ; i ++){
			 String nsb = sb + get(i);
			 backSource(length,index+1,re,nsb);
		 }
	 }
	 
	 private char get(int x){
		 if(x==0) return '(';
		 else return ')';
	 }
	 
	 private boolean isVaild(String s){
		 Stack<Character> st = new Stack<>();
		 char[] chs = s.toCharArray();
		 for(char c : chs){
			 if(c=='('){
				 st.push(')');
			 }else{
				 if(st.isEmpty()||st.pop()!= ')'){
					 return false;
				 }
			 }
		 }
		 if(st.isEmpty()){
			 return true;
		 }
		 return false;
	 }
	 public static void main(String[] args) {
		 GenerateKuoHao test = new GenerateKuoHao();
		 test.generateParenthesis(3);
		 
		
	}
}
