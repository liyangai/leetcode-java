package middle;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode faker = new ListNode(0);
		faker.next = head;
		ListNode bigger = faker;
		ListNode smaller = faker;
		for(int i = 0;i<=n;i++){
			bigger = bigger.next;
		}
		while(bigger!=null){
			bigger = bigger.next;
			smaller = smaller.next;
		}
		smaller.next = smaller.next.next;
		return faker.next;
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
