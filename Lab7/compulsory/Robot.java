package org.example;

import java.util.List;
public class Robot implements Runnable {

    private final String name;
    private final int id;
    private final SharedMemory memory;
    private final Supervisor supervisor;
    private final MatrixMap map;
    private int[] currentPosition;
    private int tokensVisited;
    boolean isStopped;

    public Robot(String name, MatrixMap map) {
        this.name = name;
        this.map = map;
        this.id = 1;
        this.memory = new SharedMemory();
        this.supervisor = new Supervisor();
    }

    public Robot(String name, int id, SharedMemory memory, Supervisor supervisor, MatrixMap map) {
        this.name = name;
        this.id = id;
        this.memory = memory;
        this.supervisor = supervisor;
        this.map = map;
        this.currentPosition = map.getRandomPosition();
        this.tokensVisited = 0;
    }

    private int tokensToNumber(List<Integer> tokens) {
        int number = 0;
        for (int i = 0; i < tokens.size(); i++) {
            number += tokens.get(i) * Math.pow(10, i * 3);
        }
        return number;
    }

    @Override
    public void run() {
        while (!supervisor.isStopped(this)) {
            // move to a random neighboring cell
            int[] newPosition = map.getRandomNeighbor(currentPosition);
            if (newPosition != null) {
                currentPosition = newPosition;
                // visit the cell and extract tokens if unvisited
                if (!map.isVisited(currentPosition)) {
                    List<Integer> tokens = memory.setAllTokenList(map.getTokenSet());
                    map.setVisited(currentPosition);
                    map.setTokens(currentPosition, tokens);
                    tokensVisited += tokens.size();
                    int number = tokensToNumber(tokens);
                    System.out.println(name + " visited cell " + currentPosition[0] + "," + currentPosition[1] +
                            " and extracted tokens " + number);
                } else {
                    System.out.println(name + " visited cell " + currentPosition[0] + "," + currentPosition[1] +
                            " but it was already visited");
                }
            } else {
                System.out.println(name + " is stuck at cell " + currentPosition[0] + "," + currentPosition[1]);
            }
            // wait for some time before moving again
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " stopped");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTokensVisited() {
        return tokensVisited;
    }

    public void pause() {
        supervisor.pauseRobot(this);
    }

    public void start() {
    }

    public boolean isStopped() {
        return isStopped;
    }
}