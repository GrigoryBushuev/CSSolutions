package Recursion;

public class ReverseLinkedList {
    private static class LinkedListNode<T>
    {
        private T value;
        private LinkedListNode<T> next;

        public LinkedListNode(T value, LinkedListNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public void setNext(LinkedListNode<T> next) {
            this.next = next;
        }

        public LinkedListNode<T> getNext() {
            return this.next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }
    }

    public static<T> LinkedListNode<T> getReversedIteratively(LinkedListNode<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        LinkedListNode<T> next = head;
        LinkedListNode<T> current = head;
        LinkedListNode<T> prev = null;

        while (next != null) {
            next = next.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev; //! at this point current == next == null
    }

    public static<T> LinkedListNode<T> getReversedRecursively(LinkedListNode<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        LinkedListNode tail = getReversedRecursivelyInternal(head);
        head.setNext(null);//! don't forget to set head.next to null to avoid cycles
        return tail;
    }

    private static<T> LinkedListNode<T> getReversedRecursivelyInternal(LinkedListNode<T> current) {
        if (current.getNext() == null) {
            return current;
        }
        LinkedListNode<T> next = current.getNext();
        LinkedListNode tail = getReversedRecursivelyInternal(next);
        next.setNext(current);
        return tail;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> fifthNode = new LinkedListNode<>(4, null);
        LinkedListNode<Integer> fourthNode = new LinkedListNode<>(3, fifthNode);
        LinkedListNode<Integer> thirdNode = new LinkedListNode<>(2, fourthNode);
        LinkedListNode<Integer> secondNode = new LinkedListNode<>(1, thirdNode);
        LinkedListNode<Integer> firstNode = new LinkedListNode<>(0, secondNode);

        LinkedListNode<Integer> result = getReversedIteratively(firstNode);
        print(result);
        result = getReversedRecursively(result);
        print(result);
    }

    private static<T> void print(LinkedListNode<T> head) {
        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }
}
