package main.list.demo;

import main.list.entity.ListNode;
import main.utils.ListNodeUtils;

/**
 * @Author: wenzf
 * @Date: 2022/08/26/21:17
 * @Description: 指定区间反转
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
 * 85->82->21->97->9->4->70->62->22->47->96->98->74->43->90
 * 起始位置：5 末位置：10
 * 循环第1次结果：
 * 85->82->21->97->4->9->70->62->22->47->96->98->74->43->90
 * 循环第2次结果：
 * 85->82->21->97->70->4->9->62->22->47->96->98->74->43->90
 * 循环第3次结果：
 * 85->82->21->97->62->70->4->9->22->47->96->98->74->43->90
 * 循环第4次结果：
 * 85->82->21->97->22->62->70->4->9->47->96->98->74->43->90
 * 循环第5次结果：
 * 85->82->21->97->47->22->62->70->4->9->96->98->74->43->90
 * 反转后的链表：
 * 85->82->21->97->47->22->62->70->4->9->96->98->74->43->90
*/
