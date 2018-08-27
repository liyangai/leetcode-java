package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring2 {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();
		if (words.length == 0)
			return list;
		int wLen = words[0].length();
		int len = s.length();
		if (len < wLen * words.length)
			return list;
		Map<String, Integer> mapW = new HashMap<String, Integer>();
		for (String word : words)
			mapW.put(word, mapW.containsKey(word) ? mapW.get(word) + 1 : 1);
		
		
		for (int start = 0; start < wLen; start++) {
			int pos = start;
			int tStart = -1;
			Map<String, Integer> mapT = new HashMap<String, Integer>(mapW);
			while (pos + wLen <= len) {
				String cand = s.substring(pos, pos + wLen);
				if (!mapW.containsKey(cand)) {
					if (tStart != -1)
						mapT = new HashMap<String, Integer>(mapW);
					tStart = -1;
				} else if (mapT.containsKey(cand)) {
					tStart = tStart == -1 ? pos : tStart;
					if (mapT.get(cand) == 1)
						mapT.remove(cand);
					else
						mapT.put(cand, mapT.get(cand) - 1);
					if (mapT.isEmpty())
						list.add(tStart);
				} else {
					while (tStart < pos) {
						String rCand = s.substring(tStart, tStart + wLen);
						if (cand.equals(rCand)) {
							tStart += wLen;
							if (mapT.isEmpty())
								list.add(tStart);
							break;
						}
						tStart += wLen;
						mapT.put(rCand, mapT.containsKey(rCand) ? mapT.get(rCand) + 1 : 1);
					}
				}
				pos += wLen;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		FindSubstring2 test = new FindSubstring2();
		String s = "cfoofoobarfoobar";
		String[] strings = {"bar","foo"};
		test.findSubstring(s, strings);
	}
}
