package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum2 {
	 public List<List<Integer>> fourSum(int[] nums, int target) {
	      List<List<Integer>> re = new ArrayList<List<Integer>>();
	      Arrays.sort(nums);
	      if(nums.length == 0) return re;
	      for(int i = 0;i<nums.length;i++){
	    	  if(i>0&&nums[i]==nums[i-1]) continue;
	    	  for(int j = i+1;j<nums.length;j++){
	    		  if(j>i+1&&nums[j]==nums[j-1])continue;
	    		  int left = j+1; int right = nums.length - 1;
	    		  while(right > left ){
	    			  if(left>j+1&&nums[left]==nums[left-1]){
	    				  left ++ ;
	    				  continue;
	    			  }
	    			  if(right<nums.length-1&&nums[right]==nums[right+1]){
	    				  right --;
	    				  continue;
	    			  }
	    			  if(nums[i]+nums[j]+nums[left]+nums[right] == target){
	    				  List<Integer> l = new ArrayList<>();
	    				  l.add(nums[i]);
	    				  l.add(nums[j]);
	    				  l.add(nums[left]);
	    				  l.add(nums[right]);
	    				  re.add(l);
	    				  right --;
                          left ++;
	    			  }else if(nums[i]+nums[j]+nums[left]+nums[right] > target){
	    				  right --;
	    			  }else{
	    				  left ++;
	    			  }
	    		  }
	    	  }
	      }
	      return re;
	 }
	 
	 
	 
	 public List<List<Integer>> fourSum2(int[] nums, int target) {
	        List<List<Integer>> res = new ArrayList<>();
	        int L = nums.length;
	        if(L <= 3) return res;
	        Arrays.sort(nums);
	        int i = 0;
	        int j = 1;
	        for (i = 0; i < L-1; i++) {

	            if(nums[i] * 4 > target) break; // nums[i] is too large
	            else if(nums[L-1] * 4 < target) break; // nums[L-1] is too small

	            if(i==0 || (i > 0 && nums[i] != nums[i-1])) {
	                for (j = i+1; j < L-1; j++) {

	                    if(nums[j] * 3 + nums[i] > target) break; // nums[j] is too large
	                    else if(nums[L-1] * 3 + nums[i] < target) break; // nums[j] is too small

	                    if (j == i+1 || (j > i+1 && nums[j] != nums[j-1])) {
	                        int lo = j + 1;
	                        int hi = L - 1;
	                        int tmpsum = target - nums[i] - nums[j];
	                        while(lo < hi) {
	                            if(nums[lo] + nums[hi] == tmpsum) {
	                                res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
	                                while(lo < hi && nums[lo]==nums[lo+1]) lo++;
	                                while(lo < hi && nums[hi]==nums[hi-1]) hi--;
	                                lo++;
	                                hi--;
	                            } else if(nums[lo] + nums[hi] > tmpsum) {
	                                hi--;
	                            } else if(nums[lo] + nums[hi] < tmpsum) {
	                                lo++;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        return res;
	    }
	 
	 
	 
	 public static void main(String[] args) {
		    List<List<Integer>> re1 = new ArrayList<List<Integer>>();
		    List<List<Integer>> re2 = new ArrayList<List<Integer>>();
		    List<Integer> l1 = new ArrayList<>();
		    l1.add(1);
		    l1.add(2);
		    re1.add(l1);
		    
		    List<Integer> l2 = new ArrayList<>();
		    l2.add(1);
		    l2.add(2);
		    re2.add(l2);
		    if(re1.equals(re2)){
		    	System.out.println("contains");
		    }else{
		    	System.out.println("not contains");
		    }
	}
}
