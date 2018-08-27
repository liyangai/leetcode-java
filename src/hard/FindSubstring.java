package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindSubstring {
	public List<Integer> findSubstring(String s, String[] words) {
		
		 List<Integer> re = new ArrayList<>();
		 List<List<Integer> > all = new ArrayList<>();
		 int length = words.length;
		 if(length == 0) return re;
		 for(int i = 0 ;i<length;i++){
			 List<Integer> l = new ArrayList<>();
			 l.add(i);
			 def(1,words,length,all,l);
		 }
		
		 for(List<Integer> single:all){
			String singleS  = getStr(single,words);
			String tempS = s;
			int i = -2;
			int last = 0;
			while(i!=-1){
				 i = tempS.indexOf(singleS);
				 	
				 	if(i!=-1){
						int nowIndex = s.length() - tempS.length() + i;
				 		tempS = tempS.substring(i+1);
				 
				 		if(!re.contains(nowIndex)){
				 			re.add(nowIndex);
				 		}
				 	}
				 	
			}
		 }
		 
		 return re;
		 
    }
	private String getStr(List<Integer> list,String[] words){
		String s = "";
		for(int i : list){
			s+=words[i];
		}
		return s;
	}

	private void def(int index, String[] words, int length, List<List<Integer>> all, 
			List<Integer> indexQ) {
		if(index == length){
			all.add(indexQ);
			return;
		}
		
		for(int i = 0;i<length;i++){
			if(!indexQ.contains(i)){
				 List<Integer> li = new ArrayList<>();
				 for(int ind : indexQ){
					 li.add(ind);
				 }
				 li.add(i);
				 def(index+1,words,length,all,li);
				
			}
		}
		
	}

	public static void main(String[] args) {
		String s = "foobarfoobar";
		String[] strings = {"bar","foo"};
		FindSubstring test = new FindSubstring();
		test.findSubstring(s, strings);
	}
}

