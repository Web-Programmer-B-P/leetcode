package com.example.fourth_step.reverse_linked_list;

import java.util.Objects;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] head = new int[]{1, 2, 3, 4, 5};
        System.out.println(reverseList(createList(head)).val);
        System.out.println(Objects.requireNonNull(reverseListRecursive(createList(head))).val);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // запоминаем следующий
            current.next = prev;          // разворачиваем ссылку
            prev = current;               // двигаем prev
            current = nextTemp;               // двигаем current
        }
        return prev; // новая голова
    }


    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
}
