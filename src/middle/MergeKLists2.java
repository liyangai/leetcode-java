package middle;

public class MergeKLists2 {
	public ListNode mergeKLists(ListNode[] lists) {
		int length = lists.length;
		if (length == 0)
			return lists[0];
		int begin = 0, end = length - 1;
		return merge(lists,begin,end);
	}

	private ListNode merge(ListNode[] lists, int begin, int end) {
		int middle = (end + begin) / 2;
		if (end > begin) {
			ListNode l1 = merge(lists, begin, middle);
			ListNode l2 = merge(lists, middle + 1, end);
			return combineTwoList(l1, l2);
		}
		return lists[begin];

	}

	public ListNode combineTwoList(ListNode head1, ListNode head2) // head1��head2Ϊͷ�ڵ������������ĺϲ�
	{
		if (head1 == null && head2 == null) // ������������������ڣ��򷵻�null
			return null;
		if (head1 == null) // ���head1�����ڣ���ֱ�ӷ���head2
			return head2;
		if (head2 == null)
			return head1;
		ListNode pHead = null;
		if (head1.val > head2.val) // ����head1��head2��ֵ������ͷ�ڵ�
		{
			pHead = head2;
			pHead.next = combineTwoList(head1, head2.next);
		} else {
			pHead = head1;
			pHead.next = combineTwoList(head1.next, head2);
		}
		return pHead;
	}
}
