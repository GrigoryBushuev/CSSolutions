package Arrays;

import java.util.LinkedList;

public class LinkedListOfLinkedLists {
    public static void main(String[] args) {
        var lists = new LinkedList<LinkedList<Integer>>();
        var list0 = new LinkedList<Integer>();
        list0.add(0);


        var list10 = new LinkedList<Integer>();
        list10.add(0);
        list10.add(1);


        lists.add(list0);

        for (LinkedList list : lists) {
            System.out.println(list);
        }
    }
}
