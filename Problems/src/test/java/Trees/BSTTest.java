package Trees;

import Trees.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BSTTest {

    @Test
    void getLevelOrderNodesTest() {
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

        var result = bst.getLevelOrderNodes();
        assertThat(result)
                .isNotEmpty()
                .hasSize(9)
                .containsExactly(rootNode, leftNode1, rightNode1, leftNode2, rightNode2, leftNode3, rightNode3, leftNode4, rightNode4);
    }

    @Test
    void getPreOrderNodesTest() {
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

        var result = bst.getPreOrderNodes();
        assertThat(result)
                .isNotEmpty()
                .hasSize(9)
                .containsExactly(rootNode, leftNode1, leftNode2, leftNode3, leftNode4, rightNode1, rightNode2, rightNode3, rightNode4);
    }
}
