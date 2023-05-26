package Trees;

import LinkedLists.ListNode;
import org.junit.jupiter.api.Test;

public class ConvertSortedListToBinarySearchTreeTest {

    @Test
    void sortedListToBST() {
        var sut = new ConvertSortedListToBinarySearchTree();
        int[] nums = new int[] { -10,-3, 0, 5, 9 };

        ListNode node = new ListNode(nums[0]);
        ListNode current = node;
        for (var i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        var result = sut.sortedListToBST(node);
    }
}