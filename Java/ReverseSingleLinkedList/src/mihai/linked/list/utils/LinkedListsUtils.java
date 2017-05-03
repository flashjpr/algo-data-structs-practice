package mihai.linked.list.utils;

import mihai.linked.list.LinkedList;
import mihai.linked.list.Node;

import java.util.List;

public final class LinkedListsUtils {

    /*
     * Given the head nodes of two lists, determine if the lists are equal.
     */
    public static boolean CompareLists(Node headA, Node headB) {

        // base case
        if (headA == null && headB == null) return true;
        else if (headA == null || headB == null) return false;

        if (headA.data == headB.data)
            return CompareLists(headA.next, headB.next);
        else
            return false;
    }


    /*
     * Given the head nodes of two sorted lists, merge them and return the head of the new list.
     */
    public static LinkedList MergeLists(LinkedList a, LinkedList b) {
        LinkedList newList = new LinkedList();
        newList.setHead(MergeListsRecursively(a.getHead(),b.getHead()));

        return newList;
    }

    private static Node MergeListsRecursively(Node headA, Node headB) {
        Node head;

        // base case
        if (headA == null) return headB;
        if (headB == null) return headA;

        if (headA.data < headB.data) {
            head = headA;
            head.next = MergeListsRecursively(headA.next, headB);
        } else {
            head = headB;
            head.next = MergeListsRecursively(headA, headB.next);
        }

        return head;
    }
}
