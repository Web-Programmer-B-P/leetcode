package com.example.fourth_step.reverse_nodes_in_k_group;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class ReverseNodesInKGroup {
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
        int k = 2;

        System.out.println(listToString(reverseKGroup(head, k)));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;

        while (true) {
            // Проверяем, есть ли k узлов
            ListNode current = prevGroupTail;
            for (int i = 0; i < k; i++) {
                if (current.next == null) {
                    return dummy.next; // меньше k узлов – выходим
                }
                current = current.next;
            }
            // Теперь current указывает на k-й узел группы (группа существует)

            ListNode groupHead = prevGroupTail.next;    // первый узел группы
            ListNode groupTail = current;               // последний узел группы
            ListNode nextGroupHead = groupTail.next;    // первый узел следующей группы

            // Разворачиваем группу (от groupHead до groupTail)
            ListNode prev = null;
            ListNode curr = groupHead;
            while (curr != nextGroupHead) { // идём до следующей группы
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            // После разворота: prev – новая голова группы (бывший groupTail)
            // Теперь groupHead стал хвостом, а curr указывает на nextGroupHead

            // Вставляем развёрнутую группу обратно
            prevGroupTail.next = groupTail;    // groupTail теперь новая голова
            groupHead.next = nextGroupHead;     // хвост группы цепляется за следующую группу

            // Переходим к следующей группе
            prevGroupTail = groupHead;
        }
    }

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
