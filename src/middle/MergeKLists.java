package middle;

public class MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		int length = lists.length;
		if(length == 0 ) return lists[0];
		int begin = 0,end = length - 1;
		while(end>0){
			begin = 0;
			while(end > begin){
				lists[begin] = combineTwoList(lists[begin],lists[end]);
				begin ++ ;
				end --;
			}
		}
		return lists[0];
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
