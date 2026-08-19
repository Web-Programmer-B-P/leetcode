package com.example.fifth_step.min_stack;

import java.util.EmptyStackException;

/**
 * Реализация стека с поддержкой получения минимального элемента за O(1).
 * <p>
 * Внутренне использует два динамических массива примитивов int:
 * <ul>
 *   <li>{@code stackArray} – хранит все значения, добавляемые в стек.
 *   <li>{@code minArray} – хранит последовательность текущих минимумов.
 * </ul>
 * Для управления логическим размером используются указатели:
 * <ul>
 *   <li>{@code topStack} – количество элементов в основном стеке, а также индекс следующей свободной ячейки.
 *   <li>{@code topMin} – количество сохранённых минимумов, а также индекс следующей свободной ячейки в minArray.
 * </ul>
 * <p>
 * При добавлении элемента (push) он записывается в stackArray по индексу topStack, затем topStack увеличивается.
 * Если новое значение меньше или равно текущему минимуму (вершине minArray), оно также записывается в minArray,
 * и topMin увеличивается. Это гарантирует, что minArray хранит все значения, которые когда-либо были минимумами,
 * включая дубликаты – это необходимо для корректного удаления.
 * <p>
 * При удалении (pop) topStack уменьшается. Если удалённый элемент равен вершине minArray, уменьшается и topMin,
 * таким образом минимум откатывается к предыдущему значению.
 * <p>
 * Массивы динамически расширяются при заполнении: при добавлении элемента, если topStack достигает длины stackArray,
 * создаются новые массивы вдвое большего размера, и старые данные копируются. Это даёт амортизированную сложность O(1)
 * для операции push.
 * <p>
 * Все операции выполняются за O(1) времени (амортизированно для push) и используют O(n) памяти,
 * где n – текущее количество элементов в стеке.
 * <p>
 * При попытке доступа к вершине или минимуму пустого стека выбрасывается {@link EmptyStackException}.
 *
 * @version 1.0
 * @see java.util.Stack
 */
public class CustomStackArray {
    /**
     * Основной массив для хранения всех значений стека.
     * Изначальный размер 10, может динамически расширяться.
     */
    private int[] stackArray = new int[10];
    /**
     * Массив для хранения последовательности минимумов.
     * Имеет тот же размер, что и stackArray, и расширяется синхронно.
     */
    private int[] minArray = new int[10];

    /**
     * Указатель на вершину основного стека.
     * Равен количеству элементов в стеке, а также индексу для записи следующего элемента.
     */
    private int topStack = 0;

    /**
     * Указатель на вершину стека минимумов.
     * Равен количеству сохранённых минимумов, а также индексу для записи следующего минимума.
     */
    private int topMin = 0;

    /**
     * Добавляет элемент на вершину стека.
     * <p>
     * Алгоритм:
     * <ol>
     *   <li>Убеждается, что в массивах достаточно места (вызов ensureCapacity).
     *   <li>Записывает value в stackArray по индексу topStack, затем увеличивает topStack.
     *   <li>Если стек минимумов пуст (topMin == 0) или value меньше либо равно текущему
     *       минимуму (minArray[topMin-1]), записывает value в minArray и увеличивает topMin.
     * </ol>
     *
     * @param value целочисленное значение для добавления в стек.
     * @see #pop()
     * @see #top()
     * @see #getMin()
     */
    public void push(int value) {
        ensureCapacity();
        stackArray[topStack++] = value;
        if (topMin == 0) {
            minArray[topMin++] = value;
        } else {
            if (value <= minArray[topMin - 1]) {
                minArray[topMin++] = value;
            }
        }
    }

    /**
     * Удаляет верхний элемент стека.
     * <p>
     * Если стек пуст, выбрасывает {@link EmptyStackException}.
     * <p>
     * Алгоритм:
     * <ol>
     *   <li>Если topStack == 0 – стек пуст, исключение.
     *   <li>Уменьшает topStack на 1 – удаляет верхний элемент из основного стека.
     *   <li>Проверяет, равен ли удалённый элемент (stackArray[topStack] после уменьшения)
     *       вершине стека минимумов (minArray[topMin - 1]). Если да – уменьшает topMin на 1,
     *       тем самым удаляя этот минимум.
     * </ol>
     * <p>
     * Физически элементы в массивах не обнуляются – они перезаписываются при следующих добавлениях.
     *
     * @throws EmptyStackException если стек пуст.
     * @see #push(int)
     * @see #top()
     */
    public void pop() {
        if (topStack == 0) {
            throw new EmptyStackException();
        }
        topStack--;
        if (stackArray[topStack] == minArray[topMin - 1]) {
            topMin--;
        }
    }

    /**
     * Возвращает верхний элемент стека без его удаления.
     *
     * @return значение верхнего элемента.
     * @throws EmptyStackException если стек пуст.
     * @see #pop()
     * @see #push(int)
     */
    public int top() {
        if (topStack == 0) {
            throw new EmptyStackException();
        }
        return stackArray[topStack - 1];
    }

    /**
     * Возвращает минимальный элемент в стеке.
     * <p>
     * Поскольку minArray хранит все значения, которые когда-либо были минимумами,
     * вершина minArray (элемент с индексом topMin-1) всегда равна текущему минимуму.
     *
     * @return минимальное значение в стеке.
     * @throws EmptyStackException если стек пуст (тогда topMin также равен 0).
     * @see #push(int)
     * @see #pop()
     */
    public int getMin() {
        if (topMin == 0) {
            throw new EmptyStackException();
        }
        return minArray[topMin - 1];
    }

    /**
     * Возвращает текущее количество элементов в стеке (логический размер).
     *
     * @return количество элементов в стеке.
     */
    public int size() {
        return topStack;
    }

    /**
     * Проверяет, пуст ли стек.
     *
     * @return true, если стек не содержит элементов, иначе false.
     */
    public boolean isEmpty() {
        return topStack == 0;
    }

    // Проверяет, достаточно ли места, и расширяет при необходимости
    private void ensureCapacity() {
        if (topStack >= stackArray.length) {
            int newSize = stackArray.length * 2;
            int[] newStack = new int[newSize];
            System.arraycopy(stackArray, 0, newStack, 0, stackArray.length);
            stackArray = newStack;

            int[] newMin = new int[newSize];
            System.arraycopy(minArray, 0, newMin, 0, minArray.length);
            minArray = newMin;
        }
    }
}
