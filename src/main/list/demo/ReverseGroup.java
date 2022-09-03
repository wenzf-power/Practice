package main.list.demo;

import main.list.entity.ListNode;
import main.utils.ListNodeUtils;

/**
 * @Author: wenzf
 * @Date: 2022/09/03/21:15
 * @Description:
 * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身
 *  给定的链表是 1→2→3→4→5
 * 对于 k=2, 你应该返回 2→1→4→3→5
 * 对于 k=3, 你应该返回 3→2→1→4→5
 */
public class ReverseGroup {

    /**
     * 每3个节点为一组
     */
    public static final int interval = 3;

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.createListNode(15);
        System.out.println("反转前链表：");
        head.print();
        reverseKGroup(head, interval,1);
    }
    public static ListNode reverseKGroup(ListNode head, int k,int j) {
        if (head != null) {
            System.out.println("第"+j+"次需要执行反转的链表：");
            head.print();
            j++;
        }
        //找到每次翻转的尾部
        ListNode tail = head;
        //遍历k次到尾部
        for (int i = 0; i < k; i++) {
            //如果不足k到了链表尾，直接返回，不翻转
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        //翻转时需要的前序和当前节点
        ListNode pre = null;
        ListNode cur = head;
        //在到达当前段尾节点前
        while (cur != tail) {
            //翻转
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //当前尾指向下一段要翻转的链表
        head.next = reverseKGroup(tail, k,j);
        if (pre != null) {
            j--;
            System.out.println("执行第"+j+"次的递归输出:");
            pre.print();
        }
        if (j == 1) {
            System.out.println("反转后的链表：");
            pre.print();
        }
        return pre;
    }
}
/***
* 运行结果示例
 * 反转前链表：
 *  7->8->24->69->74->24->11->10->97->99->2->62->49->72->79
 *  第1次需要执行反转的链表：
 *  7->8->24->69->74->24->11->10->97->99->2->62->49->72->79
 *  第2次需要执行反转的链表：
 *  69->74->24->11->10->97->99->2->62->49->72->79
 *  第3次需要执行反转的链表：
 *  11->10->97->99->2->62->49->72->79
 *  第4次需要执行反转的链表：
 *  99->2->62->49->72->79
 *  第5次需要执行反转的链表：
 *  49->72->79
 *  执行第5次的递归输出:
 *  79->72->49
 *  执行第4次的递归输出:
 *  62->2->99->79->72->49
 *  执行第3次的递归输出:
 *  97->10->11->62->2->99->79->72->49
 *  执行第2次的递归输出:
 *  24->74->69->97->10->11->62->2->99->79->72->49
 *  执行第1次的递归输出:
 *  24->8->7->24->74->69->97->10->11->62->2->99->79->72->49
 *  反转后的链表：
 *  24->8->7->24->74->69->97->10->11->62->2->99->79->72->49
*/
