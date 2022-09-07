package main.sort.demo;

/**
 * @Author: wenzf
 * @Date: 2022/09/07/16:05
 * @Description:
 *  实现无重复数字的升序数组的二分查找
 *
 * 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1
 */
public class BinarySearch {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 10, 15, 20, 28, 30, 40, 80, 99};
        int position = search(nums, 28);
        System.out.println("元素值28所在下标位置："+position);
    }

    public static int search(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
/***
* 结果示例：
 * 元素值28所在下标位置：6
*/
