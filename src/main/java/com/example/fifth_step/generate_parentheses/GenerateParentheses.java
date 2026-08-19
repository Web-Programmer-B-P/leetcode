package com.example.fifth_step.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(generateParenthesis(n));
    }


    /**
     * Генерирует все правильные скобочные последовательности длины 2n.
     * <p>
     * Алгоритм использует рекурсивный перебор с возвратом (backtracking).
     * На каждом шаге мы добавляем либо '(', либо ')', соблюдая правила:
     * <ul>
     *   <li>Количество '(' не может превышать n.
     *   <li>Количество ')' не может превышать количество '(' в любой момент времени.
     * </ul>
     * Когда оба счётчика достигают n, строка считается готовой и добавляется в ответ.
     *
     * <p><b>Ключевая идея – откат (backtracking):</b>
     * Мы используем один {@link StringBuilder} для построения строки. После того как
     * рекурсивный вызов обработал все варианты с текущим добавленным символом, мы
     * удаляем этот символ (откатываемся), чтобы попробовать другую ветвь.
     *
     * <p><b>Пример: дерево рекурсии для n = 2</b>
     * <pre>
     * (0,0) current = ""
     *   + '(' → (1,0) current = "("
     *     + '(' → (2,0) current = "(("
     *       + ')' → (2,1) current = "(()"
     *         + ')' → (2,2) current = "(())"  → сохранили
     *         - ')' → (2,1) current = "(()"
     *       - ')' → (2,0) current = "(("
     *     - '(' → (1,0) current = "("
     *     + ')' → (1,1) current = "()"
     *       + '(' → (2,1) current = "()("
     *         + ')' → (2,2) current = "()()"  → сохранили
     *         - ')' → (2,1) current = "()("
     *       - '(' → (1,1) current = "()"
     *     - ')' → (1,0) current = "("
     *   - '(' → (0,0) current = ""
     * </pre>
     * <p>
     * <b>Легенда:</b>
     * <ul>
     *   <li><b>+ '('</b> – добавление открывающей скобки перед рекурсивным вызовом.</li>
     *   <li><b>- '('</b> – удаление открывающей скобки после возврата из рекурсии (откат).</li>
     *   <li>Аналогично для ')' .</li>
     *   <li><b>→ сохранили</b> – достигнут базовый случай (open == n && close == n),
     *       строка добавляется в ответ.</li>
     * </ul>
     *
     * <p><b>Почему откат необходим?</b>
     * Без удаления последнего добавленного символа мы бы накапливали все варианты в одной строке
     * и не смогли бы перебрать все комбинации. Откат возвращает {@code current} к состоянию,
     * которое было до рекурсивного вызова, позволяя использовать один объект
     * {@link StringBuilder} для всех веток дерева.
     *
     * @param n количество пар скобок
     * @return список всех правильных скобочных последовательностей
     * @see #backtrack(List, StringBuilder, int, int, int)
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Если использовали все пары – добавляем строку
        if (open == max && close == max) {
            result.add(current.toString());
            return;
        }

        // Добавляем открывающую, если можно
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // откат
        }

        // Добавляем закрывающую, если она не нарушит правильность
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
