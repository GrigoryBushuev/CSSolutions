package LinkedLists;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DetectCycleTest {

    private ListNode getLinkedList(int[] arr, int pos) {
        var head = new ListNode(arr[0]);
        var current = head;
        ListNode cycleNode = null;
        for (var i = 1; i < arr.length; i++) {
            var next = new ListNode(arr[i]);
            if (i == pos) {
                cycleNode = next;
            }
            current.next = next;
            current = current.next;
        }
        current.next = pos == 0 ? head : cycleNode;
        return head;
    }

    @Test
    void hasCycle() {
        var sut = new DetectCycle();
        Assert.assertTrue(sut.hasCycle(getLinkedList(new int[] { 3, 2, 0, -4 }, 1)));
        Assert.assertTrue(sut.hasCycle(getLinkedList(new int[] { 1, 2 }, 0)));
        Assert.assertFalse(sut.hasCycle(getLinkedList(new int[] { 1 }, -1)));
    }
}