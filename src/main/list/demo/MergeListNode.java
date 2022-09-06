package main.list.demo;

import main.list.entity.ListNode;
import main.utils.ListNodeUtils;

/**
 * @Author: wenzf
 * @Date: 2022/09/06/11:35
 * @Description: 合并两个有序的链表
 */
public class MergeListNode {

    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtils.createAscListNode(8);
        listNode1.print();
        ListNode listNode2 = ListNodeUtils.createAscListNode(7);
        listNode2.print();
        ListNode merge = merge(listNode1, listNode2);
        merge.print();
    }
    /***
    * @Description: 采用递归的思想
    * @Param: listNode1 ,listNode2
    * @return: ListNode
    */
    public static ListNode merge(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null || listNode2 == null) {
            return listNode1 != null ? listNode1 : listNode2;
        }
        if (listNode1.val <= listNode2.val) {
             listNode1.next = merge(listNode1.next, listNode2);
             return listNode1;
        }else {
             listNode2.next = merge(listNode1, listNode2.next);
            return listNode2;
        }
    }
}
/***
* 运行结果示例：
 * 3->8->22->42->47->62->75->81
 * 13->22->45->46->80->85->97
 * 3->8->13->22->22->42->45->46->47->62->75->80->81->85->97
*/