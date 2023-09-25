package dev.shriidhar.leetcode.gridtraveler;

import java.util.HashMap;

public class GridTraveler {
    record Cell(int row, int column) {}

    /**
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m + n)
     *
     * @param rows
     * @param columns
     * @return
     */
    public static long travel(int rows, int columns) {
        HashMap<Cell, Long> memo = new HashMap<>();
        return recursive(memo, rows, columns);
    }

    private static long recursive(HashMap<Cell, Long> memo, int row, int column) {
        if (row <= 0 || column <= 0) {
            return 0;
        }
        if (row == 1 || column == 1) {
            return 1 ;
        }

        Cell cell = new Cell(row, column);
        if (memo.containsKey(cell)) {
            return memo.get(cell);
        }
        memo.put(cell, recursive(memo,row- 1, column) + recursive(memo, row, column - 1));
        return memo.get(cell);
    }
}
