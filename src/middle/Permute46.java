package middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute46 {
	 public List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> re = new ArrayList<>();
		 for(int i = 0;i<nums.length;i++){
			 List<Integer> sigleList = new ArrayList<>();
			 sigleList.add(nums[i]);
			 def(re,nums,sigleList);
		 }
		 return re;
	 }

	private void def(List<List<Integer>> re, int[] nums, List<Integer> sigleList) {
		if(sigleList.size() == nums.length){
			re.add(sigleList);
			return ;
		}
		for(int i = 0;i<nums.length;i++){
			if(!sigleList.contains(nums[i])){
				List<Integer> newList = new ArrayList<>(sigleList);
				newList.add(nums[i]);
				def(re,nums,newList);
			}
		}
		
	}
}
