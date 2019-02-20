package learn.leetcode;


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例： 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * @author MML
 * @Date 2018年12月10日
 * @version V1.0
 */
public class Solution2 {

	public static void main(String[] args) {
		
		ListNode listNode11 = new ListNode(64) ;
		listNode11.next = new ListNode(4);
		listNode11 = listNode11.next;
		System.out.println(listNode11.val);
		
		ListNode listNode1 = new ListNode(5);
		listNode1.next = new ListNode(5);
		listNode1.next.next = new ListNode(4);
		
		ListNode listNode2 = new ListNode(5);
		listNode2.next = new ListNode(5);
		listNode2.next.next = new ListNode(4);
		
		ListNode result = Solution2.addTwoNumbers(listNode1, listNode2);
		while(result.next != null) {
			System.out.println(result.val);
			result = result.next;
		} 
		System.out.println(result.val);
		
	}
	
	public static ListNode addTwoNumbers(ListNode l11, ListNode l22) {
		
		//定义一个临时节点，存储进位
		ListNode headNode = new ListNode(0);
		ListNode tempNode = headNode, l1 = l11, l2 = l22, n1 = l11, n2 = l22, t = headNode;
		//进位标识
		int ten = 0;
		//int sum = 0;
		while(l1 != null||l2 != null) {
			//获取两个节点的数
			int val1 = (l1 != null) ? l1.val : 0;
			int val2 = (l2 != null) ? l2.val : 0;
			
			int sum = val1 + val2 + ten;
			ten = sum / 10;
			tempNode.next = new ListNode(sum % 10);  //创建个位数结果的链表(赋值给下一节点)
			tempNode = tempNode.next; 
			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
			}
		//把进位存进临时链表
		if(ten > 0) {
			tempNode.next = new ListNode(ten); 
		}
		return headNode.next;
	}

//	sum /= 10;
//    if (n1 != null) {
//        sum += n1.val;
//        n1 = n1.next;
//    }
//    if (n2 != null) {
//        sum += n2.val;
//        n2 = n2.next;
//    }
//    t.next = new ListNode(sum % 10);
//    t = t.next;

//	if (sum / 10 != 0) 
//	t.next = new ListNode(1);

}
