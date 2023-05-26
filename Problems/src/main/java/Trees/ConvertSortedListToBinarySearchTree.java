package Trees;

import LinkedLists.ListNode;

import java.util.ArrayList;

public class ConvertSortedListToBinarySearchTree {

//    109. Convert Sorted List to Binary Search Tree
//    Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
//    height-balanced
//    binary search tree.
//
//    Example 1:
//
//    Input: head = [-10,-3,0,5,9]
//    Output: [0,-3,9,-10,null,5]
//    Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

//    Example 2:
//
//    Input: head = []
//    Output: []

//    Constraints:
//
//    The number of nodes in head is in the range [0, 2 * 104].
//            -105 <= Node.val <= 105


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /*
     * Definition for a binary tree node.
     */
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

    private static int findSize(ListNode head) {
        int result  = 0;
        while (head != null) {
            head = head.next;
            result++;
        }
        return result;
    }

    ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        var size = findSize(head);
        this.head = head;
        return getBST(0, size - 1);
    }

    private TreeNode getBST(int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }
        var mid = (leftIndex +  rightIndex) / 2;
        TreeNode leftNode = getBST(leftIndex, mid - 1);
        TreeNode midNode = new TreeNode(this.head.val);
        midNode.left = leftNode;
        this.head = head.next;
        midNode.right = getBST(mid + 1, rightIndex);
        return midNode;
    }

    /*
    * Covert to array then regular recrsuve array -> bst
    * */
//    public TreeNode sortedListToBST(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ArrayList<TreeNode> treeNodes = new ArrayList<>();
//
//        while (head != null) {
//            treeNodes.add(new TreeNode(head.val));
//            head = head.next;
//        }
//        return getTreeNode(treeNodes, 0, treeNodes.size());
//    }
//
//    private static TreeNode getTreeNode(ArrayList<TreeNode> nodes, int leftIndex, int rightIndex) {
//        if (leftIndex >= rightIndex) {
//            return null;
//        }
//        var mid = leftIndex + (rightIndex - leftIndex) / 2;
//        var node = nodes.get(mid);
//        node.left = getTreeNode(nodes, leftIndex, mid);
//        node.right = getTreeNode(nodes, mid + 1, rightIndex);
//        return node;
//    }
}