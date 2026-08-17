package com.example.fourth_step.linked_list_cycle;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that
 * can be reached again by continuously following the next pointer.
 * Internally,pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        // 1. Создаём список 3 -> 2 -> 0 -> -4
        ListNode head = createList(new int[]{3, 2, 0, -4});

        // 2. Находим хвост (узел со значением -4, индекс 3)
        ListNode tail = getNode(head, 3);

        // 3. Находим узел, куда должен вести хвост (индекс 1, значение 2)
        ListNode posNode = getNode(head, 1);

        // 4. СОЗДАЁМ ЦИКЛ! (Без этой строки цикла нет)
        tail.next = posNode;

        System.out.println(hasCycle(head));
    }

    /**
     * Если цикла нет: fast (или fast.next) рано или поздно станет null, потому что список конечный.
     * Тогда мы выходим из цикла и возвращаем false.
     * <p>
     * Если цикл есть: fast никогда не упирается в null – он начинает бегать по кругу и в какой-то момент нагоняет slow.
     * Тогда возвращаем true.
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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