package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> re = new ArrayList<>();
		Map<Map<Character,Integer>, List<String>> map = new HashMap<>();
		for(int i = 0 ;i < strs.length;i++){
			HashMap<Character,Integer> singleMap = new HashMap<>();
			for(int j = 0;j<strs[i].length();j++){
				char c = strs[i].charAt(j);
				if(singleMap.containsKey(c)){
					singleMap.put(c, singleMap.get(c)+1);
				}else{
					singleMap.put(c, 1);
				}
			}
			if(map.containsKey(singleMap)){
				map.get(singleMap).add(strs[i]);
			}else{
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				map.put(singleMap, list);
			}
		}
		for(Map<Character,Integer> key : map.keySet()){
			re.add(map.get(key));
		}
		
		return re;
    }
	public static void main(String[] args) {
		String[] arr = {"eat","tea","tan","ate","nat","bat"};
		GroupAnagrams49 test = new GroupAnagrams49();
		test.groupAnagrams(arr);
	}
}
