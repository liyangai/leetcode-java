package middle;

import java.util.HashMap;

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
        int largest = 1;
        int left = 0;
        int right = 1;
        int length = s.length();
        if(length == 0){
        	return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        map.put(s.substring(0, 1), 0);
        while(right < length){
        	while(map.containsKey(s.substring(right,right+1))){
        		map.remove(s.substring(left,left +1));
        		left ++;
        	}
        	
        	map.put(s.substring(right,right+1), right);
        	if(right - left + 1 > largest){
        		largest =  right - left + 1;
        	}
        	
        	right ++;
        }
        
        return largest;
        
    }
	
	public static void main(String[] args) {
		LengthOfLongestSubstring test = new LengthOfLongestSubstring();
		test.lengthOfLongestSubstring("bacdagfd");
		
	}

}
