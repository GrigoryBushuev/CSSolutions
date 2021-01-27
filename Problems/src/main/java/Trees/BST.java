package Trees;

import java.util.*;

public class BST<Key extends Comparable<Key>, Value>
{
    private TreeNode root;

    public void insert(TreeNode nodeToInsert) {
        if (nodeToInsert == null) {
            throw new IllegalArgumentException("nodeToInsert parameter is null");
        }
        if (root == null) {
            root = nodeToInsert;
            return;
        }
        var currentNode = root;
        TreeNode next = null;
        while(true) {
            if (currentNode.getKey().compareTo(nodeToInsert.getKey()) > 0) {
                next = currentNode.getLeft();
            }
            else {
                next = currentNode.getRight();
            }
            if (next != null) {
                currentNode = next;
            }
            else {
                if (currentNode.getKey().compareTo(nodeToInsert.getKey()) > 0) {
                    currentNode.setLeft(nodeToInsert);
                } else {
                    currentNode.setRight(nodeToInsert);
                }
                return;
            }
        }
    }

    public List<TreeNode> getPreOrderNodes() {
        var result = new ArrayList<TreeNode>();
        if (this.root == null) {
            return result;
        }
        var stack = new Stack<TreeNode>();
        stack.push(this.root);
        while (!stack.empty()) {
            var current = stack.pop();
            result.add(current);
            var rightNode = current.getRight();
            if (rightNode != null) {
                stack.push(rightNode);
            }
            var leftNode = current.getLeft();
            if (leftNode != null) {
                stack.push(leftNode);
            }
        }
        return result;
    }

    public List<TreeNode> getLevelOrderNodes() {
        var result = new ArrayList<TreeNode>();
        if (this.root == null) {
            return result;
        }
        var queue = new ArrayDeque<TreeNode>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            var currentNode = queue.removeFirst();
            result.add(currentNode);
            var leftNode = currentNode.getLeft();
            if (leftNode != null) {
                queue.add(leftNode);
            }
            var rightNode = currentNode.getRight();
            if (rightNode != null) {
                queue.add(rightNode);
            }
        }
        return result;
    }
}
