package main.tree.entity;

import main.list.entity.ListNode;

/**
 * @Author: wenzf
 * @Date: 2022/09/07/16:20
 * @Description: 二叉树节点实体类
 */
public class TreeNode {
   public int val = 0;
   public TreeNode left = null;
   public TreeNode right = null;
   public TreeNode(int val) {
     this.val = val;
   }
  public TreeNode() {
  }
}
