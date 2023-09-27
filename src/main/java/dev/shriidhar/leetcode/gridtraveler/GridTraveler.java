package dev.shriidhar.leetcode.gridtraveler;

import java.util.HashMap;

public class GridTraveler {
    record Cell(int row, int column) {}

    /**
     * Determines total number of ways `m * n` grid can be traveled from top-left to bottom-right corner
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m + n)
     *
     * @param rows       number of rows
     * @param columns   number of rows
     * @return  total number of ways grid can be traveled, otherwise 0
     */
    public static long memoization(int rows, int columns) {
        HashMap<Cell, Long> memo = new HashMap<>();
        return recurse(memo, rows, columns);
    }

    private static long recurse(HashMap<Cell, Long> memo, int row, int column) {
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
        memo.put(cell, recurse(memo,row- 1, column) + recurse(memo, row, column - 1));
        return memo.get(cell);
    }

    /**
     * Tabulation approach to determine total number of ways `m * n` grid can be traveled from top-left to bottom-right corner
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m + n)
     *
     * @param rows       number of rows
     * @param columns   number of rows
     * @return  total number of ways grid can be traveled, otherwise 0
     */

    public static long tabulation(int rows, int columns) {
        if (rows <= 0 || columns <= 0) return 0;
        if (rows == 1 || columns == 1) return 1;

        long[][] grid = new long[rows + 2][columns + 2];
        grid[1][1] = 1;

        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                grid[row][column + 1] += grid[row][column];
                grid[row + 1][column] += grid[row][column];
            }
        }

        return grid[rows][columns];
    }
}
