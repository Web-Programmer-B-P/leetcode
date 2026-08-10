package com.example.first_step.insert_interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent
 * the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * <p>
 * Two intervals are considered overlapping if they share at least one point.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
 * still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 * <p>
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n) {
            // Фаза 1: все интервалы, которые заканчиваются до начала newInterval
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                i++;
            }
            // Фаза 2: пересекающиеся интервалы — сливаем с newInterval
            else if (intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            // Фаза 3: все оставшиеся (непересекающиеся справа) — выходим из цикла
            else {
                break;
            }
        }

        // Добавляем объединённый newInterval
        result.add(newInterval);

        // Добавляем оставшиеся интервалы (после точки break)
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Преобразуем список в массив
        return result.toArray(new int[result.size()][]);
    }
}
