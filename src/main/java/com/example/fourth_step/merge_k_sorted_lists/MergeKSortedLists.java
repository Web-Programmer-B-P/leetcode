package com.example.fourth_step.merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeKSortedLists {
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
        ListNode[] listNodes = createLists(new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}, {7, 8}});

//        System.out.println(listToString(mergeKListsPriorityQueue(listNodes)));
        System.out.println(listToString(mergeKLists(listNodes)));
    }


    /**
     * Объединяет k отсортированных связных списков в один отсортированный список.
     * <p>
     * Алгоритм использует приоритетную очередь (мин-кучу), чтобы всегда извлекать
     * узел с наименьшим значением среди текущих голов всех списков.
     *
     * <p><b>Пошаговое выполнение:</b>
     * <ol>
     *   <li>Создаётся {@link PriorityQueue} с компаратором по значению {@code val}.</li>
     *   <li>В очередь добавляются головы всех непустых списков из массива.</li>
     *   <li>Создаётся фиктивный узел {@code dummy} для упрощения сборки результата,
     *       и указатель {@code current}, который будет перемещаться по новой цепочке.</li>
     *   <li>Пока очередь не пуста:
     *     <ul>
     *       <li>Из очереди извлекается узел с минимальным значением ({@code node}).</li>
     *       <li>Он прикрепляется к {@code current.next}, и {@code current} переходит на него.</li>
     *       <li>Если у {@code node} есть следующий узел ({@code node.next != null}),
     *           он добавляется в очередь (становится новой головой своего списка).</li>
     *     </ul>
     *   </li>
     *   <li>После опустошения очереди все узлы перераспределены, возвращается {@code dummy.next}.</li>
     * </ol>
     *
     * <p><b>Сложность:</b>
     * <ul>
     *   <li>Время: O(N log k), где N – общее число узлов, k – количество списков.</li>
     *   <li>Память: O(k) для хранения элементов в очереди (плюс память для результата, которая уже была выделена).</li>
     * </ul>
     *
     * @param lists массив голов отсортированных связных списков (может содержать null)
     * @return голова объединённого отсортированного списка, или null, если входной массив пуст или все списки пусты
     */
    public static ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.val)
        );

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }


    /**
     * Объединяет K отсортированных связных списков в один отсортированный список
     * с использованием попарного слияния (Divide and Conquer).
     * <p>
     * Алгоритм работает следующим образом:
     * <ol>
     *   <li>На каждом уровне (step = 1, 2, 4, ...) списки попарно сливаются.</li>
     *   <li>Слитые результаты сохраняются на место первых элементов пар.
     *       Например, при step = 1 сливаются (0,1), (2,3), (4,5) и т.д.
     *       Результаты записываются в индексы 0, 2, 4, ...</li>
     *   <li>Затем step удваивается, и процесс повторяется:
     *       сливаются группы, которые уже содержат по 2 списка, затем по 4 и т.д.</li>
     *   <li>После log₂(k) уровней все списки объединяются в один,
     *       который оказывается в индексе 0 исходного массива.</li>
     * </ol>
     *
     * <p>Этот подход гарантирует, что каждый узел участвует в слиянии
     * всего log₂(k) раз, что даёт оптимальную сложность.
     *
     * <p><b>Сложность:</b>
     * <ul>
     *   <li><b>Время:</b> O(N log k), где N – общее число узлов во всех списках,
     *       k – количество списков. Каждый узел обрабатывается на каждом уровне,
     *       а уровней всего log₂(k).</li>
     *   <li><b>Память:</b> O(1) дополнительной памяти (без учёта стека рекурсии,
     *       если используется итеративный {@code mergeTwoLists}).</li>
     * </ul>
     *
     * <p><b>Преимущества:</b>
     * <ul>
     *   <li>Не требует дополнительной структуры данных (кучи).</li>
     *   <li>Использует минимальную дополнительную память.</li>
     *   <li>Хорошо масштабируется для большого числа списков.</li>
     * </ul>
     *
     * @param lists массив голов отсортированных связных списков.
     *              Может содержать {@code null} для пустых списков.
     * @return голова объединённого отсортированного списка,
     * или {@code null}, если массив пуст или все списки пусты.
     * @see #mergeTwoLists(ListNode, ListNode) для слияния двух списков
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int step = 1;
        int n = lists.length;
        while (step < n) {
            for (int i = 0; i + step < n; i += step * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + step]);
            }
            step *= 2;
        }
        return lists[0];
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

    public static ListNode[] createLists(int[][] arrays) {
        if (arrays == null) return null; // защита
        ListNode[] heads = new ListNode[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            heads[i] = createList(arrays[i]); // используем существующий метод
        }
        return heads;
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
