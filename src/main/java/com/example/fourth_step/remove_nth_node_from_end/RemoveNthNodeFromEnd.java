package com.example.fourth_step.remove_nth_node_from_end;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEnd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        int n = 2;
//        System.out.println(listToString(removeNthFromEndSimple(head, n)));
        System.out.println(listToString(removeNthFromEnd(head, n)));
    }


    /**
     * Суть подхода с использованием двух указателей с фиксированным отрывом, в итоге тот который медленный указатель
     * будет указывать на позицию удаляемого элемента -1, дальше все просто переброс ссылки.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) { // i <= n, потому что начинаем с 0, итого n+1 итераций
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * Суть подхода таже что и с двумя указателями ищем длину списка, затем позицию удаляемого узла -1 только через
     * формулу длина списка - n -1, после чего также перебрасываем ссылку.
     */
    public static ListNode removeNthFromEndSimple(ListNode head, int n) {
        int length = getSize(head);

        if (length == n) {
            return head.next;
        }

        ListNode current = head;
        for (int i = 0; i < length - n - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    // Вспомогательный метод для создания списка из массива
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static int getSize(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
