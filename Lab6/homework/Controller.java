package com.example.lab6;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import java.awt.image.RenderedImage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.lab6.Color.BLUE;
import static com.example.lab6.Color.RED;

public class Controller{
    private static final int CANVAS_SIZE = 750;

    // Draw a line from (100, 100) to (300, 300)
    double x1 = 100;
    double y1 = 100;
    double x2 = 300;
    double y2 = 300;
    private int dotsNumber;
    private Float lineProbability;

    Player player1;
    Player player2;
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

        gc.setStroke(Color.BLACK);
        // gc.strokeLine(x1, y1, x2, y2);

        // Add a mouse event handler to the canvas
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // Check if the mouse click is within a certain distance from the line segment
            double mouseX = event.getX();
            double mouseY = event.getY();
            double distToLine = pointToLineDistance(mouseX, mouseY, x1, y1, x2, y2);
            double distToPoint1 = Math.sqrt(Math.pow(mouseX - x1, 2) + Math.pow(mouseY - y1, 2));
            double distToPoint2 = Math.sqrt(Math.pow(mouseX - x2, 2) + Math.pow(mouseY - y2, 2));
            double lineLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            if (distToLine < 10 && distToPoint1 <= lineLength && distToPoint2 <= lineLength) {
                System.out.println("Mouse clicked on the line.");
            }
        });
    }

    // Helper method to calculate the distance between a point and a line segment
    public static double pointToLineDistance(double x1, double y1, double x2, double y2, double x, double y) {
        double A = x - x1;
        double B = y - y1;
        double C = x2 - x1;
        double D = y2 - y1;

        double dot = A * C + B * D;
        double len_sq = C * C + D * D;
        double param = dot / len_sq;

        double xx, yy;

        if (param < 0) {
            xx = x1;
            yy = y1;
        } else if (param > 1) {
            xx = x2;
            yy = y2;
        } else {
            xx = x1 + param * C;
            yy = y1 + param * D;
        }

        double dx = x - xx;
        double dy = y - yy;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void exportCanvas() throws IOException {
        File file = new File("canvas.png");
        System.out.println("is file null ? " + file);
        try {
            WritableImage writableImage = new WritableImage(CANVAS_SIZE, CANVAS_SIZE);
            canvas.snapshot(null, writableImage);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            ImageIO.write(renderedImage, "png", file);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error!");
        }

        // Create an output stream to write the object to a file
        FileOutputStream fileOut1 = new FileOutputStream("player1.ser");
        ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);

        FileOutputStream fileOut2 = new FileOutputStream("player2.ser");
        ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);

        // Serialize the object to the output stream
        out1.writeObject(player1);
        out2.writeObject(player2);

        // Close the output streams
        out1.close();
        fileOut1.close();
        out2.close();
        fileOut2.close();

        System.out.println("The player objects serialized and saved to player1.ser and player2.ser");
    }

    public void loadGame(){
        // Create an ObjectInputStream to read from the file player1.ser
        try (FileInputStream fileIn = new FileInputStream("player1.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            // Read the player1 object from the file and cast it to Player
            player1 = (Player) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Create an ObjectInputStream to read from the file player2.ser
        try (FileInputStream fileIn = new FileInputStream("player2.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            // Read the player1 object from the file and cast it to Player
            player2 = (Player) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void initialize() {
        initializeSpinner();
        initializeChoiceBox();
    }
    @FXML
    protected void onCreateNewGameButtonClick(){
        lineProbability = choiceBox.getValue();
        dotsNumber = spinner.getValue();

        System.out.println("Dots number: " + dotsNumber);
        System.out.println("Line probability: " + lineProbability + "\n");

        // Create the player objects to be serialized
        player1 = new Player("Alex", RED, new HashMap<>());
        player2 = new Player("Marcel", BLUE, new HashMap<>());

        updateCanvas();

    }

}