package com.example.fourth_step.merge_two_sorted_lists;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = createList(new int[]{1, 2, 4});
        ListNode list2 = createList(new int[]{1, 3, 4});

//        System.out.println(listToString(mergeTwoLists(list1, list2)));
        System.out.println(listToString(mergeTwoListsRecursive(list1, list2)));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // прицепляем остаток
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    /**
     *merge(1→2→4, 1→3→4):
     *   1 <= 1 → берём list1 (1)
     *   list1.next = merge(2→4, 1→3→4)
     *<p>
     *   merge(2→4, 1→3→4):
     *     2 > 1 → берём list2 (1)
     *     list2.next = merge(2→4, 3→4)
     *<p>
     *     merge(2→4, 3→4):
     *       2 <= 3 → берём list1 (2)
     *       list1.next = merge(4, 3→4)
     *<p>
     *       merge(4, 3→4):
     *         4 > 3 → берём list2 (3)
     *         list2.next = merge(4, 4)
     *<p>
     *         merge(4, 4):
     *           4 <= 4 → берём list1 (4)
     *           list1.next = merge(null, 4)
     *<p>
     *           merge(null, 4):
     *             list1 == null → возвращаем list2 (4)
     *<p>
     *           возвращаем 4 (list1)
     *         возвращаем 3 → 4
     *       возвращаем 2 → 3 → 4
     *     возвращаем 1 → 2 → 3 → 4
     *   возвращаем 1 → 1 → 2 → 3 → 4
     */
    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list2.next, list1);
            return list2;
        }
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
