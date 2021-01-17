package Trees;

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
}
