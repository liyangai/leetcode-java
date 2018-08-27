package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
		List<List<Integer>> re = new ArrayList<>();
		for(int i = 0;i<candidates.length;i++){
			List<Integer> sigleRe = new ArrayList<Integer>();
			sigleRe.add(candidates[i]);
			def(re,sigleRe,target,candidates,i);
		}
		return re;
    }

	private void def(List<List<Integer>> re, List<Integer> sigleRe,  int target,int[] candidates,int index) {
		if(getSum(sigleRe)>target){
			return ;
		}else if(getSum(sigleRe)==target){
			re.add(sigleRe);
			return ;
		}
		for(int i = index;i< candidates.length;i++){
			List<Integer> newRe = new ArrayList<Integer>(sigleRe);
			newRe.add(candidates[i]);
			def(re,newRe,target,candidates,i);
		}
		
	}
	
	private int getSum(List<Integer> sigleRe){
		int re = 0;
		for(int i :sigleRe){
			re += i;
		}
		return re;
	}
	
}
