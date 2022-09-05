package main.utils;

import main.list.entity.ListNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wenzf
 * @Date: 2022/08/26/21:08
 * @Description:
 */
public class ListNodeUtils {

    public static int min = 1000;

    public static int max = 0;

    public static ListNode descListNode = new ListNode(0);

    public static ListNode ascListNode = new ListNode(0);


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

    /***
    * @Description: 随机生成长度为Length的数字小于100整型升序单向链表
    * @Param: length
    * @return: ListNode
    */
    public static ListNode createAscListNode(int length) {
        return  Ascending(createListNode(length));
    }

    /***
     * @Description: 整型数值链表升序排序
     * @Param: ListNode
     * @return: ListNode
     */
    public static ListNode Ascending(ListNode listNode) {
        ListNode descListNode = new ListNode(0);
        ListNode cur = listNode;
        List<Integer> list = new ArrayList<>();
        while (cur.next != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        list.add(cur.val);
        List<Integer> sortList = list.stream().sorted().collect(Collectors.toList());
        sortList.forEach(e->{descListNode.add(e);});
        return descListNode.next;
    }

    /***
     * @Description: 随机生成长度为Length的数字小于100整型降序单向链表
     * @Param: length
     * @return: ListNode
     */
    public static ListNode createDescListNode(int length) {
        return  Descending(createListNode(length));
    }

    /***
    * @Description: 整型数值链表降序排序（方法1)
    * @Param: ListNode
    * @return: ListNode
    */
    public static ListNode Descending(ListNode listNode) {
        ListNode descListNode = new ListNode(0);
        ListNode cur = listNode;
        List<Integer> list = new ArrayList<>();
        while (cur.next != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        list.add(cur.val);
        List<Integer> sortList = list.stream().sorted().collect(Collectors.toList());
        for (int i = sortList.size()-1; i >=0 ; i--) {
            descListNode.add(sortList.get(i));
        }
        return descListNode.next;
    }


    /***
    * @Description: 获取链表中的最小值（方法1）
    * @Param: listNode
    * @return: int
    */
    public static int getMin(ListNode listNode) {
        if (listNode != null) {
            if (listNode.val < min ) {
                min = listNode.val;
            }
            getMin(listNode.next);
        }
        return min;
    }

    /***
    * @Description: 获取链表中的最大值(方法1）
    * @Param: listNode
    * @return: int
    */
    public static int getMax(ListNode listNode) {
        if (listNode != null) {
            if (listNode.val > max ) {
                max = listNode.val;
            }
            getMax(listNode.next);
        }
        return  max;
    }

    /***
     * @Description: 整型数值链表降序排序（方法2）
     * @Param: ListNode
     * @return: ListNode
     */
    public static ListNode getDescListNode(ListNode listNode) {
        if (listNode != null) {
            int maxValue = getMaxValue(listNode);
            descListNode.add(maxValue);
            int tempValue = listNode.val;
            ListNode cur = listNode;
            while (cur != null) {
                if (cur.val != maxValue) {
                    cur = cur.next;
                }else {
                    if (tempValue != maxValue) {
                        listNode.val = cur.val;
                        cur.val = tempValue;
                    }
                    break;
                }
            }
            getDescListNode(listNode.next);
        }
        return descListNode.next;
    }


    /***
     * @Description: 获取链表中的最大值(方法2）
     * @Param: listNode
     * @return: int
     */
    public static int getMaxValue(ListNode listNode) {
        int maxValue = listNode.val;
        ListNode temp = listNode;
        while (temp != null) {
            if (temp.val > maxValue) {
                maxValue = temp.val ;
            }
            temp = temp.next;
        }
        return maxValue;
    }

    /***
     * @Description: 整型数值链表升序排序（方法2)
     * @Param: ListNode
     * @return: ListNode
     */
    public static ListNode getAscListNode(ListNode listNode) {
        if (listNode != null) {
            int minValue = getMinValue(listNode);
            ascListNode.add(minValue);
            int tempValue = listNode.val;
            ListNode cur = listNode;
            while (cur != null) {
                if (cur.val != minValue) {
                    cur = cur.next;
                }else {
                    if (tempValue != minValue) {
                        listNode.val = cur.val;
                        cur.val = tempValue;
                    }
                    break;
                }
            }
            getAscListNode(listNode.next);
        }
        return ascListNode.next;
    }

    /***
     * @Description: 获取链表中的最小值（方法2）
     * @Param: listNode
     * @return: int
     */
    public static int getMinValue(ListNode listNode) {
        int minValue = listNode.val;
        ListNode temp = listNode;
        while (temp != null) {
            if (temp.val < minValue) {
                minValue = temp.val ;
            }
            temp = temp.next;
        }
        return minValue;
    }
}
