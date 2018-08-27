package middle;

import java.util.ArrayList;
import java.util.Stack;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	 public ListNode addTwoNumbers() {
		 	ListNode l1 = new ListNode(9);
		 	ListNode l2 = new ListNode(1);
		 	l2.next = new ListNode(9);
		 	l2.next.next = new ListNode(9);
		 	l2.next.next.next = new ListNode(9);
		 	l2.next.next.next.next = new ListNode(9);
		 	int index1 = 0,index2 = 0;
		 	int result1 = 0, result2 = 0;
		 	ListNode temp1 = l1;
		 	ListNode temp2 = l2;
			Stack<Integer> list1 = new Stack<>();
			Stack<Integer> list2 = new Stack<>();
	        while(temp1 != null){
	        	index1 ++;
	        	list1.push(temp1.val);
	        	temp1 = temp1.next;
	        }
	        while(temp2 != null){
	        	index2 ++;
	        	list2.push(temp2.val);
	        	temp2 = temp2.next;
	        }
	        
	       while(!list1.isEmpty()){
	    	   result1 += list1.pop() * (int)Math.pow(10, index1-1);
	    	   index1 --;
	       }
	       
	       while(!list2.isEmpty()){
	    	   result2 += list2.pop() * (int)Math.pow(10.0, index2-1);
	    	   index2 --;
	       }
	       
	       int result = result1 + result2;
	       
	       int start = result%10;
	       result = result/10;
	       ListNode resultNode = new ListNode(start);
	       ListNode nowNode = resultNode;
	       while(true){
	    	   if(result == 0){
	    		   break;
	    	   }else{
	    		   ListNode childNode = new ListNode(result%10);
	    		   result = result/10;
	    		   nowNode.next = childNode;
	    		   nowNode = childNode;
	    	   }
	       }
	       return resultNode;
	        
	 }
	
	 public static void main(String[] args) {
		 AddTwoNumbers a = new AddTwoNumbers();
		 a.addTwoNumbers();
	}
}
