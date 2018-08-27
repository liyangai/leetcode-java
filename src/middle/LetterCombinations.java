package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	 private String[] strings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	 public List<String> letterCombinations(String digits) {
		 List<String> re  = new ArrayList<>();
		 backtracking(digits,0,re,"");
		 return re;
		 
	 }
	private void backtracking(String digits, int index, List<String> re,String result) {
		String s = strings[digits.charAt(index) - '0'];
		for(int i = 0;i<s.length();i++){
			String newRes = result + s.charAt(i);
			if(index == digits.length()-1){
				re.add(newRes);
			}else{
				backtracking(digits,index+1,re,newRes);
			}
		}
		
	}
	
	public static void main(String[] args) {
		LetterCombinations test = new LetterCombinations();
		test.letterCombinations("23");
	}
	
}
