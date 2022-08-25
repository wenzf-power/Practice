package main.list.entity;

/**
 * @Author: wenzf
 * @Date: 2022/08/25/20:59
 * @Description: 单向链表实体类
 */
public class ListNode {
    private int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode() {
    }

    /**
     * @Description: 添加一个节点
     */
    public void add(int value) {
        ListNode newNode = new ListNode(value);
        if(this.next == null){
            this.next = newNode;
        }else{
            this.next.add(value);
        }
    }

    /**
     * @Description: 输出链表
     */
    public void print() {
        System.out.print(this.val);
        if(this.next != null) {
            System.out.print("->");
            this.next.print();
        }else {
            //换行
            System.out.println();
        }
    }
}
