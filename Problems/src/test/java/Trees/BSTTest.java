package Trees;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BSTTest {
    private BST sut;
    private TreeNode<Integer, String> rootNode;
    private TreeNode<Integer, String> leftNode1;
    private TreeNode<Integer, String> rightNode1;
    private TreeNode<Integer, String> leftNode2;
    private TreeNode<Integer, String> rightNode2;
    private TreeNode<Integer, String> leftNode3;
    private TreeNode<Integer, String> rightNode3;
    private TreeNode<Integer, String> leftNode4;
    private TreeNode<Integer, String> rightNode4;

    @BeforeAll
    public void setup() {
        this.sut = new BST<>();

        this.rootNode = new TreeNode<>(5, "Root");
        this.sut.insert(rootNode);

        this.leftNode1 = new TreeNode<>(4, "Left");
        this.rightNode1 = new TreeNode<>(6, "Right");
        this.leftNode2 = new TreeNode<>(1, "Left");
        this.rightNode2 = new TreeNode<>(9, "Right");
        this.leftNode3 = new TreeNode<>(2, "Left");
        this.rightNode3 = new TreeNode<>(7, "Right");
        this.leftNode4 = new TreeNode<>(3, "Left");
        this.rightNode4 = new TreeNode<>(8, "Right");

        this.sut.insert(this.leftNode1);
        this.sut.insert(this.rightNode1);
        this.sut.insert(this.leftNode2);
        this.sut.insert(this.rightNode2);
        this.sut.insert(this.leftNode3);
        this.sut.insert(this.rightNode3);
        this.sut.insert(this.leftNode4);
        this.sut.insert(this.rightNode4);
    }

    @Test
    public void getLevelOrderNodesTest() {
        java.util.List<TreeNode> result = this.sut.getLevelOrderNodes();
        assertThat(result)
                .isNotEmpty()
                .hasSize(9)
                .containsExactly(this.rootNode, this.leftNode1, this.rightNode1, this.leftNode2, this.rightNode2, this.leftNode3, this.rightNode3, this.leftNode4, this.rightNode4);
    }

    @Test
    public void getPreOrderNodesTest() {
        java.util.List<TreeNode> result = this.sut.getNodes(BST.TraverseOrder.PreOrder);
        assertThat(result)
                .isNotEmpty()
                .hasSize(9)
                .containsExactly(this.rootNode, this.leftNode1, this.leftNode2, this.leftNode3, this.leftNode4, this.rightNode1, this.rightNode2, this.rightNode3, this.rightNode4);
    }

    @Test
    public void getInOrderNodesTest() {
        java.util.List<TreeNode> result = this.sut.getNodes(BST.TraverseOrder.InOrder);
        assertThat(result)
                .isNotEmpty()
                .hasSize(9)
                .containsExactly(this.leftNode2, this.leftNode3, this.leftNode4, this.leftNode1, this.rootNode, this.rightNode1, this.rightNode3, this.rightNode4, this.rightNode2);
    }

    @Test
    public void isValidBST_returnsTrue() {
        Assert.assertTrue(this.sut.isValidBST(this.sut.getRoot()));
    }

    @Test
    public void isValidBSTInorderIterative_returnsTrue() {
        Assert.assertTrue(this.sut.isValidBSTInorderIterative(this.sut.getRoot()));
    }
}