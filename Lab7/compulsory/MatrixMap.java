package org.example;

import java.util.*;

public class MatrixMap {
    private int[][] cells;
    private Set<Integer> tokenSet;

    public MatrixMap(int[][] cells, Set<Integer> tokenSet) {
        this.cells = cells;
        this.tokenSet = tokenSet;
    }

    public int[][] getCells() {
        return cells;
    }

    public void setCells(int[][] cells) {
        this.cells = cells;
    }

    public Set<Integer> getTokenSet() {
        return tokenSet;
    }

    public void setTokenSet(Set<Integer> tokenSet) {
        this.tokenSet = tokenSet;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private int n;

    public MatrixMap(int n) {
        this.n = n;
        cells = new int[n][n];
        tokenSet = new HashSet<>();
        for (int i = 1; i <= n * n * n; i++) {
            tokenSet.add(i);
        }
    }

    public synchronized boolean hasToken(int token) {
        return tokenSet.contains(token);
    }

    public synchronized int[] getRandomPosition() {
        Random rand = new Random();
        int row = rand.nextInt(n);
        int col = rand.nextInt(n);
        return new int[] {row, col};
    }

    public synchronized void markVisited(int row, int col) {
        cells[row][col] = 1;
    }

    public synchronized boolean isVisited(int row, int col) {
        return cells[row][col] == 1;
    }

    public synchronized void extractTokens(int row, int col, int numTokens) {
        Random rand = new Random();
        for (int i = 0; i < numTokens; i++) {
            int token = rand.nextInt(n * n * n) + 1;
            while (!hasToken(token)) {
                token = rand.nextInt(n * n * n) + 1;
            }
            tokenSet.remove(token);
            cells[row][col] += token;
        }
    }

    public synchronized int getTotalTokens() {
        int total = 0;
        for (int[] row : cells) {
            for (int cell : row) {
                total += cell;
            }
        }
        return total;
    }

    public int[] getRandomNeighbor(int[] currentPosition) {
        List<int[]> neighbors = new ArrayList<int[]>();
        int row = currentPosition[0];
        int col = currentPosition[1];

        // Check neighbors to the left, right, up, and down
        if (col > 0) {
            int[] leftNeighbor = { row, col - 1 };
            if (!isVisited(leftNeighbor)) {
                neighbors.add(leftNeighbor);
            }
        }
        if (col < cells.length - 1) {
            int[] rightNeighbor = { row, col + 1 };
            if (!isVisited(rightNeighbor)) {
                neighbors.add(rightNeighbor);
            }
        }
        if (row > 0) {
            int[] topNeighbor = { row - 1, col };
            if (!isVisited(topNeighbor)) {
                neighbors.add(topNeighbor);
            }
        }
        if (row < cells.length - 1) {
            int[] bottomNeighbor = { row + 1, col };
            if (!isVisited(bottomNeighbor)) {
                neighbors.add(bottomNeighbor);
            }
        }

        // Choose a random neighbor to return
        if (neighbors.size() > 0) {
            int randomIndex = (int) (Math.random() * neighbors.size());
            return neighbors.get(randomIndex);
        } else {
            return null;
        }
    }

    boolean isVisited(int[] leftNeighbor) {
        // todo
        return false;
    }

    public void setVisited(int[] currentPosition) {
    }

    public void setTokens(int[] currentPosition, List<Integer> tokens) {
    }
}