package Recursion.Permutations;
import org.junit.Test;

public class BSTArraysTest {
    @Test
    public void generateAllBSTOrders() {
        var bst = new BSTArrays.Node(6);
        bst.right = new BSTArrays.Node(8);
        bst.right.left = new BSTArrays.Node(7);
        bst.right.right = new BSTArrays.Node(9);
        bst.left = new BSTArrays.Node(3);
//        bst.left.left = new BSTArrays.Node(1);
//        bst.left.right = new BSTArrays.Node(4);
        var sut = new BSTArrays();
        var result = sut.allBSTOrders(bst);
    }

}