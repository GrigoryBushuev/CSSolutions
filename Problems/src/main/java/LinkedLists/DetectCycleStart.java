package LinkedLists;

/*
142. Linked List Cycle II
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.


Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.


Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */

/*
The idea is that distance from the meeting point to the node where the cycle begins is equal to the distance from beginning of the list
https://www.youtube.com/watch?v=S5TcPmTl6ww
X - distance from the beginning of the list to the node where the cycle begins
Y - distance from the node where the cycle begins to the meeting node
Z - distance from the meeting point to the node where the cycle begins

the distance that is passed by the slow pointer is X + Y
the distance that is passed by the fast pointer is X + 2Y + Z

2*Dslow = Dfast
2*(X + Y) = X + Y + Z
2X + 2Y = X + Y + Z
X = Z
*/
public class DetectCycleStart {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        var slow = head;
        var fast = head;

        var hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
