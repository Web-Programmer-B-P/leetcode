package com.example.fourth_step.linked_list_cycleII;


/**
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
 * It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * <p>
 * Do not modify the linked list.
 */

public class LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        // Пример: [3,2,0,-4], pos = 1
        ListNode head = createList(new int[]{3, 2, 0, -4});
        ListNode tail = getNode(head, 3);
        ListNode posNode = getNode(head, 1);
        if (tail != null && posNode != null) {
            tail.next = posNode; // создаём цикл
        }

        ListNode cycleStart = detectCycle(head);
        if (cycleStart != null) {
            System.out.println("Цикл начинается с узла со значением: " + cycleStart.val);
        } else {
            System.out.println("Цикла нет");
        }
        // Вывод: Цикл начинается с узла со значением: 2
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    // Вспомогательный метод для создания списка из массива
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static ListNode getNode(ListNode head, int index) {
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }
}