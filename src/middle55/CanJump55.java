package middle55;

public class CanJump55 {
	 public boolean canJump(int[] nums) {
		 int len = nums.length;
		 if(len == 1) return true;
		 int target = nums[len-1];
		 int targetIndex = len-1;
		 for(int i = len-1 ;i >= 0 ; i--){
			 if(targetIndex - i <= nums[i]){
				 targetIndex = i;
			 }
		 
		 }
		 
		 if(targetIndex == 0) return true;
		 return false;
	 }
}
