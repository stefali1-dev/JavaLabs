package com.example.lab6;

import java.util.*;

public class GraphGenerator {
    public ArrayList<Point> nodeList;

    public GraphGenerator(int size) {
        this.nodeList = new ArrayList<>();
        switch(size) {
            case 4:

                nodeList.add(new Point(150, 100));
                nodeList.add(new Point(600, 100));
                nodeList.add(new Point(150, 500));
                nodeList.add(new Point(600, 500));

                break;
            case 5:
                // positioning the 5 nodes of a graph
                nodeList.add(new Point(375, 100));
                nodeList.add(new Point(650, 300));
                nodeList.add(new Point(600, 600));
                nodeList.add(new Point(200, 600));
                nodeList.add(new Point(150, 300));
                break;
            case 6:
                // positioning the 6 nodes of a graph
                nodeList.add(new Point(100, 300));
                nodeList.add(new Point(250, 100));
                nodeList.add(new Point(500, 100));
                nodeList.add(new Point(650, 300));
                nodeList.add(new Point(500, 500));
                nodeList.add(new Point(250, 500));
                break;
            default:
                System.out.println("Graph size is between 4 and 6 nodes");
        }
    }

    public Map<Point, ArrayList<Point> > generateGraph(float lineProbability)
    {
        Map<Point, ArrayList<Point> > graphMap = new HashMap<>();
        // number from 1 to 100
        int percent = (int) (lineProbability * 100);

        for(Point point : nodeList){
            ArrayList<Point> adjacentNodesList = new ArrayList<>();

            // iterating through adjacent nodes
            for(Point otherPoint : nodeList){
                if(point != otherPoint){
                    int randomInt = new Random().nextInt(101);

                    // chance of percent% to enter this if
                    if(randomInt < percent){
                        // adding a vertex
                        adjacentNodesList.add(otherPoint);
                    }
                }
            }
            graphMap.put(point, adjacentNodesList);
        }
        return graphMap;
    }

    public ArrayList<Point> getNodeList() {
        return nodeList;
    }
}
