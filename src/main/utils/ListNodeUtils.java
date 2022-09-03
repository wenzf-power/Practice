package main.utils;

import main.list.entity.ListNode;

import java.util.Random;

/**
 * @Author: wenzf
 * @Date: 2022/08/26/21:08
 * @Description:
 */
public class ListNodeUtils {

    /**
    * @Description: 随机生成长度为Length的数字小于100整型单向链表
    * @Param: length
    * @return: ListNode
    */
    public static ListNode createListNode(int length) {
        Random random = new Random();
        ListNode listNode = new ListNode(random.nextInt(100));
        for (int i = 1 ; i < length; i++) {
            listNode.add(random.nextInt(100));
        }
        return listNode;
    }
}
