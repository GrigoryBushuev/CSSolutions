package Trees;

import java.util.*;

/*
* BST with non-recursive operations
*/
public class BST<Key extends Comparable<Key>, Value>
{
    public enum TraverseOrder {
        PreOrder,
        InOrder,
        PostOrder
    }

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

    private void PreOrderTraversal(List treeNodes, Stack<TreeNode> stack) {
        while (!stack.empty()) {
            var current = stack.pop();
            treeNodes.add(current);
            var rightNode = current.getRight();
            if (rightNode != null) {
                stack.push(rightNode);
            }
            var leftNode = current.getLeft();
            if (leftNode != null) {
                stack.push(leftNode);
            }
        }
    }

    private void InOrderTraversal(List treeNodes, Stack<TreeNode> stack) {
        while (!stack.empty()) {
            var current = stack.peek();
            var rightNode = current.getRight();
            if (rightNode != null) {
                stack.push(rightNode);
            }
            var leftNode = current.getLeft();
            if (leftNode != null) {
                stack.push(leftNode);
            } else {
                stack.pop();
                treeNodes.add(current);
            }
        }
    }

    public List<TreeNode> getNodes(TraverseOrder traverseOrder) {
        var result = new ArrayList<TreeNode>();
        if (this.root == null) {
            return result;
        }
        var stack = new Stack<TreeNode>();
        stack.push(this.root);
        switch (traverseOrder) {
            case InOrder:
                InOrderTraversal(result, stack);
                break;
            case PreOrder:
                PreOrderTraversal(result, stack);
                break;
            case PostOrder:
                break;
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

    public boolean isValidBST(TreeNode root) {
        if (root.getLeft() == null && root.getRight() == null) {
            return true;
        }
        return isValidBSTNode(root.getLeft(), Long.MIN_VALUE, root.getKey()) && isValidBSTNode(root.getRight(), root.getKey(), Long.MAX_VALUE);
    }

    private boolean isValidBSTNode(TreeNode root, Comparable min, Comparable max) {
        if (root == null) {
            return true;
        }
        if (!(root.getKey().compareTo(max) < 0 && root.getKey().compareTo(min) > 0 && (root.getLeft() == null || root.getLeft().getKey().compareTo(root.getKey()) < 0) &&  (root.getRight() == null || root.getRight().getKey().compareTo(root.getKey()) > 0))) {
            return false;
        }
        return isValidBSTNode(root.getLeft(), min, root.getKey()) && isValidBSTNode(root.getRight(), root.getKey(), max);
    }
}
