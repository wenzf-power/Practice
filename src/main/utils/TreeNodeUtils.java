package main.utils;

import main.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: wenzf
 * @Date: 2022/09/07/16:45
 * @Description:
 */
public class TreeNodeUtils {

    /***
    * @Description: 随机
    * @Param:  height
    * @return: List<TreeNode>
    */
    public static List<TreeNode> createTreeNode(int height) {
        int total = (int) Math.pow(2, height) - 1;
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(0,new TreeNode(0));
        for (int i = 1; i <= total; i++) {
            int value = RandomUtils.Random(100);
            treeNodeList.add(i,new TreeNode(value));
        }
        for (int i = 1; i <= total; i++) {
            TreeNode treeNode = treeNodeList.get(i);
            if (2 * i < total) {
                treeNode.left = treeNodeList.get(2 * i);
                treeNode.right = treeNodeList.get(2 * i + 1);
            }
        }
        return treeNodeList;
    }
}
