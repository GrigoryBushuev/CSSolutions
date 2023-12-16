package Trees;


public class LCBST {
    public LCTreeNode deleteNode(LCTreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (isLeaf(root)) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            var max = getMin(root.right);
            deleteNode(root.right, max.val);
            max.left = root.left;
            if (max != root.right) {
                max.right = root.right;
            }
            return max;
        }
        if (isLeaf(root)) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public static LCTreeNode getMin(LCTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static LCTreeNode getMax(LCTreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static boolean isLeaf(LCTreeNode node) {
        return node.left == null && node.right == null;
    }

    public LCTreeNode insert(LCTreeNode root, int val) {
        var newNode = new LCTreeNode(val);
        if (root == null) {
            return newNode;
        }
        var parent = getParent(root, val);
        if (parent.val > val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return root;
    }

    private LCTreeNode getParent(LCTreeNode root, int val) {
        while (root.left != null || root.right != null) {
            if (root.val > val) {
                if (root.left == null) {
                    break;
                }
                root = root.left;
            } else {
                if (root.right == null) {
                    break;
                }
                root = root.right;
            }
        }
        return root;
    }
}
