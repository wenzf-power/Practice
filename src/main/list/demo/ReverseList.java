package main.list.demo;

import main.list.entity.ListNode;

import java.util.Random;

/**
 * @Author: wenzf
 * @Date: 2022/08/25/21:00
 * @Description:
 * 定一个单链表的头结点pHead(该头节点是有值的 ， 比如在下图 ， 它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 *
 * 数据范围： 0≤n≤10000\leq n\leq10000≤n≤1000
 * 要求：空间复杂度 O(1)O(1)O(1) ，时间复杂度 O(n)O(n)O(n) 。
 *
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 */
public class ReverseList {
    public static final int SIZE = 10;

    /**
    * @Description: 反转链表
    * @Param: head
    * @return: ListNode
    */
    public static ListNode reverseList(ListNode head) {
        //pre指针：用来指向反转后的节点，初始化为null
        ListNode pre = null;
        //当前节点指针
        ListNode cur = head;
        //循环迭代
        while(cur!=null){
            //curNext 节点，永远指向当前节点cur的下一个节点
            ListNode curNext = cur.next;
            //反转，当前的节点指向其前一个节点
            cur.next = pre;
            //更新pre
            pre = cur;
            //更新当前节点指针
            cur = curNext ;
        }
        //返回反转之后的头节点pre
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            listNode.add(random.nextInt(10));
        }
        System.out.println("反转前的链表：");
        listNode.print();
        ListNode node = reverseList(listNode);
        System.out.println("反转之后的链表：");
        node.print();
    }
}
/**
 * 结果示例
 * 反转前的链表：
 * 0->9->2->2->1->2->7->6->9->5->9
 * 反转之后的链表：
 * 9->5->9->6->7->2->1->2->2->9->0
 */
