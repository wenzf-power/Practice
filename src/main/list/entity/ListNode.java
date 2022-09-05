package main.list.entity;

/**
 * @Author: wenzf
 * @Date: 2022/08/25/20:59
 * @Description: 单向链表类
 */
public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode() {
    }
    /**
    * @Description: 链表长度属性
    */
    public static int length = 1;

    /**
     * @Description: 链表位置属性
     */
    public static int position = 1;

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

    /***
    * @Description: 获取链表长度
    * @Param: []
    * @return: int
    */
    public int getLength(){
        if(this.next !=null){
            length++;
            this.next.getLength();
        }
        return length;
    }
    /***
    * @Description: 获取链表值离头节点值最近的位置
    * @Param: val：值;pos: 1 表示从头节点开始
    * @return: int 返回位置
    */
    public int getPosition(int val,int pos){
        if (pos == 1) {
            if (this.next != null) {
                if (this.val != val) {
                    position++;
                    this.next.getPosition(val,1);
                }
            }
        }else{
            position = 1;
            this.next.getPosition(val,1);
        }
        return position;
    }
}
