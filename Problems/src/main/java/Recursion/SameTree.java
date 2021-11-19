package Recursion;

import Trees.TreeNode;

import java.util.ArrayDeque;

public class SameTree {
    private static boolean isEqualNode(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.getKey() == q.getKey();
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (!isEqualNode(p, q)) {
            return false;
        }

        if (p == null) {
            return true;
        }

        var pDeque = new ArrayDeque<TreeNode>();
        var qDeque = new ArrayDeque<TreeNode>();

        pDeque.addLast(p);
        qDeque.addLast(q);
        while (!pDeque.isEmpty()) {
            var pNode = pDeque.pollFirst();
            var qNode = qDeque.pollFirst();

            if (!(isEqualNode(pNode.getLeft(), qNode.getLeft()) && isEqualNode(pNode.getRight(), qNode.getRight()))) {
                return false;
            }

            if (pNode.getLeft() != null) {
                pDeque.addLast(pNode.getLeft());
                qDeque.addLast(qNode.getLeft());
            }

            if (pNode.getRight() != null) {
                pDeque.addLast(pNode.getRight());
                qDeque.addLast(qNode.getRight());
            }
        }
        return true;
    }
}
