package main.tree.demo;

import main.tree.entity.TreeNode;
import main.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenzf
 * @Date: 2022/09/07/16:27
 * @Description: 二叉树的前序遍历
 */
public class PreOrder {
    public static void main(String[] args) {
        List<TreeNode> treeNode = TreeNodeUtils.createTreeNode(3);
        for (int i = 1; i <= treeNode.size()-1; i++) {
            System.out.print(treeNode.get(i).val+" ");
        }
        TreeNode root = treeNode.get(1);
        List<Integer> list = new ArrayList<>();
        preOrder(list,root);
        System.out.println();
        list.stream().forEach(e -> System.out.print(e + " "));
    }

    public static void preOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(list, root.left);
        preOrder(list,root.right);
    }
}
