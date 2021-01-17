package Trees;

import Trees.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BSTTest {


    @Test
    void insertRootNode() {
        var bst = new BST<>();

        var rootNode = new TreeNode<>(5, "Root");
        bst.insert(rootNode);

        var leftNode1 = new TreeNode<>(4, "Left");
        var rightNode1 = new TreeNode<>(6, "Right");
        var leftNode2 = new TreeNode<>(1, "Left");
        var rightNode2 = new TreeNode<>(9, "Right");
        var leftNode3 = new TreeNode<>(2, "Left");
        var rightNode3 = new TreeNode<>(7, "Right");
        var leftNode4 = new TreeNode<>(3, "Left");
        var rightNode4 = new TreeNode<>(8, "Right");

        bst.insert(leftNode1);
        bst.insert(rightNode1);
        bst.insert(leftNode2);
        bst.insert(rightNode2);
        bst.insert(leftNode3);
        bst.insert(rightNode3);
        bst.insert(leftNode4);
        bst.insert(rightNode4);
    }
}
