package com.example.lab6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Player implements Serializable {
    String name;
    Color color;

    // the graph that consists of the lines currently drown by the player
    Map<Point, ArrayList<Point>> playerGraph;

    public Player(String name, Color color, Map<Point, ArrayList<Point>> playerGraph) {
        this.name = name;
        this.color = color;
        this.playerGraph = playerGraph;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Map<Point, ArrayList<Point>> getPlayerGraph() {
        return playerGraph;
    }

    public void setPlayerGraph(Map<Point, ArrayList<Point>> playerGraph) {
        this.playerGraph = playerGraph;
    }
}
