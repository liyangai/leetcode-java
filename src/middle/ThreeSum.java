package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i = 0 ; i< nums.length;i++){
			int target = nums[i];
			if(target>0) break;
			if(i>0&&nums[i] == nums[i-1]) continue;
			int left = i+1,right = nums.length-1;
			while(left<right){
				if(left>i+1&&nums[left] == nums[left-1]){
					left ++ ;
					continue;
				}
				if(right<nums.length-1 && nums[right]==nums[right+1]){
					right -- ;
					continue;
				}
				
				if(nums[left] + nums[right] + target ==0){
					List<Integer> l = new ArrayList<>();
					l.add(target);
					l.add(nums[right]);
					l.add(nums[left]);
					re.add(l);
					left ++;
                    right --;
				}else if(nums[left] + nums[right] + target > 0){
					right --;
				}else{
					left ++;
				}
			}
		}
		
		return re;
		
	}
	
	public static void main(String[] args) {
		ThreeSum test = new ThreeSum();
		int[] arr = new int[]{-2,0,0,2,2};
		test.threeSum(arr);
		
	}
}
