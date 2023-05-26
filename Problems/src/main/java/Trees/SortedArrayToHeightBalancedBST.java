package Trees;

/*
    108. Convert Sorted Array to Binary Search Tree
    Given an integer array nums where the elements are sorted in ascending order, convert it to a
    height-balanced
    binary search tree.

    Example 1:


    Input: nums = [-10,-3,0,5,9]
    Output: [0,-3,9,-10,null,5]
    Explanation: [0,-10,5,null,-3,null,9] is also accepted:

    Example 2:


    Input: nums = [1,3]
    Output: [3,1]
    Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.


    Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in a strictly increasing order.
 */

import java.util.Stack;

public class SortedArrayToHeightBalancedBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Frame {
        TreeNode node;
        int leftIndex;
        int rightIndex;

        Frame(TreeNode node, int leftIndex, int rightIndex) {
            this.node = node;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Stack<Frame> stack = new Stack<>();
        TreeNode root = new TreeNode();
        stack.push(new Frame(root,0, nums.length));
        while (!stack.isEmpty()) {
            Frame frame = stack.pop();
            int leftIndex = frame.leftIndex;
            int rightIndex = frame.rightIndex;
            TreeNode node = frame.node;
            int mid = leftIndex + (rightIndex - leftIndex) / 2;
            node.val = nums[mid];
            if (leftIndex < mid) {
                node.left = new TreeNode();
                stack.push(new Frame(node.left, leftIndex, mid));
            }
            if (mid + 1 < rightIndex) {
                node.right = new TreeNode();
                stack.push(new Frame(node.right, mid + 1, rightIndex));
            }
        }
        return root;
    }

//    public TreeNode sortedArrayToBST(int[] nums) {
//        return getNode(nums, 0, nums.length);
//    }

    private TreeNode getNode(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return null;
        }
        var mid = leftIndex + (rightIndex - leftIndex) / 2;
        var root = new TreeNode(nums[mid]);
        root.left = getNode(nums, leftIndex, mid);
        root.right = getNode(nums, mid + 1, rightIndex);
        return root;
    }
}
