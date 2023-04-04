package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        int n = 10; // size of the map
        int numRobots = 4; // number of robots
        int numTokens = n * n; // total number of tokens
        int[][] map = new int[n][n];
        BlockingQueue<Integer> tokenQueue = new ArrayBlockingQueue<>(numTokens);
        for (int i = 1; i <= numTokens; i++) {
            tokenQueue.offer(i);
        }
        MatrixMap robotMap = new MatrixMap(map, (Set<Integer>) tokenQueue);
        List<Thread> robotThreads = new ArrayList<>();
        List<Robot> robotList = new ArrayList<>();
        for (int i = 0; i < numRobots; i++) {
            Robot robot = new Robot("Robot" + (i + 1), robotMap);
            robotList.add(robot);
            robotThreads.add(new Thread(robot));
        }
        Supervisor supervisor = new Supervisor(robotList);
        supervisor.start();
    }
}