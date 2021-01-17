package Trees;

public class TreeNode<Key extends Comparable<Key>, Value> {
    private Key key;
    private Value value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Key key, Value value) {
        this(key, value, null, null);
    }

    public TreeNode(Key key, Value value, TreeNode left, TreeNode right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }


    public Key getKey() {
        return this.key;
    }

    public Value getValue() {
        return this.value;
    }

    public void setLeft(TreeNode leftNode) {
        this.left = leftNode;
    }

    public void setRight(TreeNode rightNode) {
        this.right = rightNode;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public TreeNode getLeft() {
        return this.left;
    }
}


