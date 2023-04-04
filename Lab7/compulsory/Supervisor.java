package org.example;

import java.util.List;

public class Supervisor {
    private List<Robot> robots;

    public Supervisor() {
    }

    public Supervisor(List<Robot> robots) {
        this.robots = robots;
    }

    public void startAllRobots() {
        for (Robot robot : robots) {
            robot.start();
        }
    }

    public void startRobot(Robot robot) {
        robot.start();
    }

    public void pauseAllRobots() {
        for (Robot robot : robots) {
            robot.pause();
        }
    }

    public void pauseRobot(Robot robot) {
        robot.pause();
    }

    public boolean isStopped(Robot robot) {
        return robot.isStopped();
    }

    public void start() {
        for (Robot robot : robots) {
            robot.start();
        }
    }
}
