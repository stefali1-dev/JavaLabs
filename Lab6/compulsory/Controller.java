package com.example.lab6;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller{
    private int dotsNumber;
    private Float lineProbability;
    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private ChoiceBox<Float> choiceBox;

    @FXML
    private Button createNewGameButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button exitButton;
    @FXML
    public Canvas canvas;

    private void initializeSpinner(){
        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(4, 6, 5);

        spinner.setValueFactory(spinnerValueFactory);
    }

    private void initializeChoiceBox() {
        List<Float> list = new ArrayList<Float>();
        list.add(1.0f);
        list.add(0.8f);
        list.add(0.6f);
        list.add(0.4f);
        list.add(0.2f);

        ObservableList obList = FXCollections.observableList(list);
        choiceBox.getItems().clear();
        choiceBox.setItems(obList);
        choiceBox.setValue(1.0f);
    }


    private void drawPoint( GraphicsContext gc, Point point, int radius){
        gc.fillOval(point.x-radius, point.y-radius, radius * 2, radius * 2);

    }
    
    private void drawLine(GraphicsContext gc, Point a, Point b)
    {
        gc.strokeLine(a.x, a.y, b.x, b.y);
    }
    
    public void updateCanvas(){
        // Get the graphics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // Set line width
        gc.setLineWidth(2.0);

        ArrayList<Point> nodeList = new GraphGenerator(dotsNumber).getNodeList();
        for(Point node : nodeList){
            drawPoint(gc, node, 10);
        }

        Map<Point, ArrayList<Point> > graphMap = new GraphGenerator(dotsNumber).generateGraph(lineProbability);

        for (Map.Entry<Point, ArrayList<Point> > entry : graphMap.entrySet()){

            for(Point adjacentPoint : entry.getValue()){
                // draws a lime between the key point and all his adjacent points
                drawLine(gc, entry.getKey(), adjacentPoint);
            }
        }
    }

    @FXML
    public void initialize() {
        initializeSpinner();
        initializeChoiceBox();
    }
    @FXML
    protected void onCreateNewGameButtonClick() {
        lineProbability = choiceBox.getValue();
        dotsNumber = spinner.getValue();

        System.out.println("Dots number: " + dotsNumber);
        System.out.println("Line probability: " + lineProbability + "\n");

        updateCanvas();
    }

}