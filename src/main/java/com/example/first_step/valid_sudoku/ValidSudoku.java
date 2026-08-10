package com.example.first_step.valid_sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according
 * to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
//        char[][] board = new char[][]
//                     {
//                         {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
//                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//                    };
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudokuBit(board));
        System.out.println(isValidSudokuBoolean(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int len = board.length;
        if (len != 9 && board[0].length != 9) {
            return false;
        }

        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                String rowKey = "row" + i + c;
                String colKey = "col" + j + c;
                String boxKey = "box" + (i / 3) + (j / 3) + c;
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuBit(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                int digit = c - '1';
                int bit = 1 << digit;

                int boxIndex = (i / 3) * 3 + (j / 3);

                if ((rows[i] & bit) != 0 || (cols[j] & bit) != 0 || (boxes[boxIndex] & bit) != 0) {
                    return false;
                }

                rows[i] |= bit;
                cols[j] |= bit;
                boxes[boxIndex] |= bit;
            }
        }
        return true;
    }

    public static boolean isValidSudokuBoolean(char[][] board) {
        boolean[][] rows = new boolean[9][9];    // rows[i][digit] — была ли цифра digit в строке i
        boolean[][] cols = new boolean[9][9];    // cols[j][digit] — была ли цифра digit в столбце j
        boolean[][] boxes = new boolean[9][9];   // boxes[boxIndex][digit] — была ли цифра digit в блоке

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int digit = c - '1'; // '1' -> 0, '9' -> 8
                int boxIndex = (i / 3) * 3 + (j / 3); // номер блока 0..8

                if (rows[i][digit] || cols[j][digit] || boxes[boxIndex][digit]) {
                    return false; // дубликат
                }

                rows[i][digit] = true;
                cols[j][digit] = true;
                boxes[boxIndex][digit] = true;
            }
        }
        return true;
    }
}
