# 📘 Освоение алгоритмов на Java

Решение задач с LeetCode для глубокого понимания структур данных и алгоритмов.  
**108 задач · 15 паттернов.**

---

## 🧭 Мой подход

Я прохожу все задачи **последовательно, по этапам**.  
На каждом этапе разбираю новые темы и структуры данных.

После завершения всего списка я **начинаю новый круг** — решаю все задачи заново, постепенно уменьшая количество подсказок.  
Так я повторяю материал, пока паттерны не становятся естественными.

---

## 🎯 Почему именно эти 108 задач?

Этот список — не случайный набор. Он составлен на основе реальной статистики собеседований и проверен на практике.

### Основано на данных

Анализ тысяч реальных интервью показывает, что:

- **20 паттернов покрывают 94% всех задач** на собеседованиях.
- **10 паттернов покрывают 80% задач**.
- Большинство успешных кандидатов решают **75–150 качественных задач**, а не 500 случайных.
- Некоторые авторы утверждают, что **50 задач могут покрыть 90% интервью**, но 108 дают полную картину.

### Полный список паттернов в этом плане

Всего в плане **15 паттернов**, которые покрывают все ключевые темы:

1. Хеш-таблицы
2. Два указателя
3. Бинарный поиск
4. Сортировка
5. Связные списки
6. Скользящее окно (Sliding Window)
7. Стеки и очереди
8. Деревья
9. Куча (PriorityQueue)
10. Жадные алгоритмы (Greedy)
11. Графы (BFS/DFS, Union-Find, Dijkstra)
12. Backtracking
13. Динамическое программирование
14. Префиксные суммы
15. Битовые операции

Каждый этап в списке задач соответствует одному или нескольким из этих паттернов.

### Самые частые паттерны на собеседованиях (для ориентира)

| Паттерн | Частота появления |
|---------|-------------------|
| Два указателя | 23% |
| Динамическое программирование | 18% |
| BFS/DFS (графы и деревья) | 16% |
| Скользящее окно | 14% |
| Бинарный поиск | 12% |
| Хеш-таблицы | основа большинства задач |


### Проверенный путь

План построен так, чтобы вести от простого к сложному:

1. Освоить один паттерн через 8–12 задач.
2. Научиться узнавать этот паттерн в разных условиях.
3. Комбинировать несколько паттернов в одной задаче.

Этот подход даёт **глубокое понимание**, а не заучивание решений.

---

## 📚 Полный список задач

### ✅ Этап 1. Массивы + Хеш-таблицы (12 задач)

1. [Two Sum](https://leetcode.com/problems/two-sum/) – Easy – HashMap
2. [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) – Easy – HashSet
3. [Valid Anagram](https://leetcode.com/problems/valid-anagram/) – Easy – HashMap / int[26]
4. [Group Anagrams](https://leetcode.com/problems/group-anagrams/) – Medium – HashMap + сортировка
5. [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/) – Medium – HashSet
6. [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) – Medium – HashMap + bucket
7. [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/) – Medium – Prefix / suffix
8. [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) – Medium – HashSet для строк/колонок/блоков
9. [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) – Easy – Отслеживание минимума
10. [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) – Medium – Kadane's algorithm
11. [Merge Intervals](https://leetcode.com/problems/merge-intervals/) – Medium – Сортировка + слияние
12. [Insert Interval](https://leetcode.com/problems/insert-interval/) – Medium – Вставка + слияние

---

### 📘 Этап 2. Два указателя + Sliding Window (12 задач)

13. [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) – Easy – Два указателя
14. [Two Sum II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) – Medium – Два указателя
15. [3Sum](https://leetcode.com/problems/3sum/) – Medium – Два указателя + дубликаты
16. [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) – Medium – Жадные два указателя
17. [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) – Hard – Два указателя / стек
18. [Move Zeroes](https://leetcode.com/problems/move-zeroes/) – Easy – Read/Write pointers
19. [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) – Easy – In-place два указателя
20. [Longest Substring Without Repeating](https://leetcode.com/problems/longest-substring-without-repeating-characters/) – Medium – Sliding window
21. [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) – Medium – Sliding window + freq
22. [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) – Medium – Variable window
23. [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) – Medium – Fixed window + HashMap
24. [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) – Medium – Variable window с K заменами

---

### 📙 Этап 3. Бинарный поиск (8 задач)

25. [Binary Search](https://leetcode.com/problems/binary-search/) – Easy – Классика
26. [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/) – Medium – Бинарный поиск в матрице
27. [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) – Medium – Поиск в сдвинутом массиве
28. [Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/) – Medium – С дубликатами
29. [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) – Medium – Поиск минимума
30. [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) – Medium – Поиск по ответу
31. [Capacity To Ship Packages](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) – Medium – Поиск по ответу
32. [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) – Hard – Бинарный поиск на двух массивах

---

### 📕 Этап 4. Связные списки (8 задач)

33. [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) – Easy – Итеративный + рекурсивный реверс
34. [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) – Easy – Слияние
35. [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) – Easy – Fast & slow pointers
36. [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) – Medium – Найти начало цикла
37. [Remove Nth Node From End](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) – Medium – Два указателя с отступом
38. [Reorder List](https://leetcode.com/problems/reorder-list/) – Medium – Середина + реверс + слияние
39. [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) – Hard – PriorityQueue
40. [Reverse Nodes in k‑Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) – Hard – Реверс группами

---

### 📒 Этап 5. Стеки и очереди (8 задач)

41. [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) – Easy – Stack
42. [Min Stack](https://leetcode.com/problems/min-stack/) – Medium – Stack с минимумом
43. [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/) – Medium – Стек для вычислений
44. [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) – Medium – Backtracking + стек
45. [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) – Medium – Монотонный стек
46. [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) – Hard – Монотонный стек
47. [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) – Hard – Deque (монотонная очередь)
48. [Decode String](https://leetcode.com/problems/decode-string/) – Medium – Стек для вложенных строк

---

### 🌳 Этап 6. Деревья (12 задач)

49. [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) – Easy – DFS / рекурсия
50. [Same Tree](https://leetcode.com/problems/same-tree/) – Easy – Сравнение деревьев
51. [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/) – Easy – Рекурсия
52. [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) – Medium – BFS (очередь)
53. [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) – Medium – Inorder или min/max
54. [Kth Smallest in BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) – Medium – Inorder traversal
55. [Construct Binary Tree from Preorder/Inorder](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) – Medium – Рекурсивное построение
56. [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) – Hard – DFS + максимум пути
57. [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) – Hard – BFS/DFS + сериализация
58. [Lowest Common Ancestor](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) – Medium – LCA
59. [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/) – Easy – Проверка поддерева
60. [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/) – Easy – DFS + диаметр

---

### ⛰ Этап 7. Куча (Heap) и Greedy (8 задач)

61. [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) – Medium – Min-Heap / QuickSelect
62. [Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/) – Easy – Min-Heap фиксированного размера
63. [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/) – Easy – Max-Heap (PriorityQueue с reverse)
64. [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/) – Medium – Min-Heap / Max-Heap
65. [Jump Game](https://leetcode.com/problems/jump-game/) – Medium – Greedy
66. [Jump Game II](https://leetcode.com/problems/jump-game-ii/) – Medium – Greedy + BFS
67. [Task Scheduler](https://leetcode.com/problems/task-scheduler/) – Medium – Greedy + Heap
68. [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/) – Medium – Heap / сортировка

---

### 🔗 Этап 8. Графы (12 задач)

69. [Number of Islands](https://leetcode.com/problems/number-of-islands/) – Medium – DFS / BFS на матрице
70. [Max Area of Island](https://leetcode.com/problems/max-area-of-island/) – Medium – DFS / BFS
71. [Clone Graph](https://leetcode.com/problems/clone-graph/) – Medium – DFS / BFS + HashMap
72. [Course Schedule](https://leetcode.com/problems/course-schedule/) – Medium – Топологическая сортировка
73. [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) – Medium – Топологическая сортировка
74. [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) – Medium – DFS с двух сторон
75. [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) – Medium – BFS (Multi-source)
76. [Word Ladder](https://leetcode.com/problems/word-ladder/) – Hard – BFS на графе слов
77. [Network Delay Time](https://leetcode.com/problems/network-delay-time/) – Medium – Dijkstra
78. [Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/) – Medium – Union-Find / MST
79. [Number of Provinces](https://leetcode.com/problems/number-of-provinces/) – Medium – Union-Find / DFS
80. [Redundant Connection](https://leetcode.com/problems/redundant-connection/) – Medium – Union-Find

---

### 🔙 Этап 9. Backtracking (8 задач)

81. [Subsets](https://leetcode.com/problems/subsets/) – Medium – Backtracking — основа
82. [Subsets II](https://leetcode.com/problems/subsets-ii/) – Medium – С дубликатами
83. [Permutations](https://leetcode.com/problems/permutations/) – Medium – Backtracking с visited
84. [Permutations II](https://leetcode.com/problems/permutations-ii/) – Medium – С дубликатами
85. [Combination Sum](https://leetcode.com/problems/combination-sum/) – Medium – Backtracking с повторениями
86. [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/) – Medium – Без повторений
87. [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) – Medium – Backtracking
88. [N-Queens](https://leetcode.com/problems/n-queens/) – Hard – Backtracking на доске

---

### 🧮 Этап 10. Динамическое программирование (14 задач)

89. [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) – Easy – 1D DP
90. [House Robber](https://leetcode.com/problems/house-robber/) – Medium – 1D DP
91. [House Robber II](https://leetcode.com/problems/house-robber-ii/) – Medium – 1D DP + circular
92. [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) – Medium – 2D DP
93. [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) – Medium – 2D DP
94. [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) – Medium – 1D DP + binary search
95. [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/) – Medium – 0/1 Knapsack
96. [Coin Change](https://leetcode.com/problems/coin-change/) – Medium – Unbounded Knapsack
97. [Coin Change II](https://leetcode.com/problems/coin-change-ii/) – Medium – Unbounded (количество способов)
98. [Word Break](https://leetcode.com/problems/word-break/) – Medium – 1D DP + HashSet
99. [Decode Ways](https://leetcode.com/problems/decode-ways/) – Medium – 1D DP
100. [Unique Paths](https://leetcode.com/problems/unique-paths/) – Medium – 2D DP
101. [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/) – Medium – 2D DP
102. [Edit Distance](https://leetcode.com/problems/edit-distance/) – Hard – 2D DP

---

### ➕ Бонус: Префиксные суммы и битовые операции (6 задач)

103. [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/) – Easy – Prefix sum
104. [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) – Medium – Prefix sum + HashMap
105. [Single Number](https://leetcode.com/problems/single-number/) – Easy – XOR
106. [Single Number II](https://leetcode.com/problems/single-number-ii/) – Medium – Битовые операции
107. [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/) – Medium – Битовая арифметика
108. [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/) – Easy – Битовая арифметика

---

## ⚙️ Как я работаю

- **10–15 минут** самостоятельной попытки решить задачу.
- Если не выходит — смотрю **объяснение** (не код), затем пишу своё решение.
- После прохождения всех 108 задач начинаю **новый круг** — решаю всё заново, с каждым разом всё больше полагаясь на себя.

---

⭐ **Этот метод помогает мне постепенно и глубоко освоить алгоритмы.**