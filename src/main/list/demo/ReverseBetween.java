package main.list.demo;

import main.list.entity.ListNode;
import main.utils.ListNodeUtils;

/**
 * @Author: wenzf
 * @Date: 2022/08/26/21:17
 * @Description:
 */
public class ReverseBetween {

    public static final int START_POSITION = 5;

    public static final int END_POSITION = 10;

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.createListNode(15);
        System.out.println("反转前链表：");
        head.print();
        //虚拟节点
        ListNode res = new ListNode(-1);
        res.next = head;
        //前序节点
        ListNode pre = new ListNode();
        //当前节点
        ListNode cur = head;
        //找到起始位置
        for (int i = 1; i < START_POSITION; i++) {
            pre = cur;
            cur = pre.next;
        }
        //从起始位置反转到末位置
        System.out.println("起始位置："+START_POSITION+" 末位置："+END_POSITION);
        for (int i = START_POSITION,j=1; i <END_POSITION ; i++,j++) {
            ListNode curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = pre.next;
            pre.next = curNext;
            System.out.println("循环第"+j+"次结果：");
            head.print();
        }
        System.out.println("反转后的链表：");
        head.print();
    }
}
/***
* 运行结果示例;
 * 反转前链表：
 * 0->82->49->88->80->49->83->23->31->24->48->73->47->2->83->85
 * 起始位置：5 末位置：10
 * 循环第1次结果：
 * 0->82->49->88->49->80->83->23->31->24->48->73->47->2->83->85
 * 循环第2次结果：
 * 0->82->49->88->83->49->80->23->31->24->48->73->47->2->83->85
 * 循环第3次结果：
 * 0->82->49->88->23->83->49->80->31->24->48->73->47->2->83->85
 * 循环第4次结果：
 * 0->82->49->88->31->23->83->49->80->24->48->73->47->2->83->85
 * 循环第5次结果：
 * 0->82->49->88->24->31->23->83->49->80->48->73->47->2->83->85
 * 反转后的链表：
 * 0->82->49->88->24->31->23->83->49->80->48->73->47->2->83->85
*/
