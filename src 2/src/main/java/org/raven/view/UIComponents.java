package org.raven.view;


import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;



public class UIComponents extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Layering Example");

        // Create the first canvas with an image
        Canvas canvas1 = new Canvas(1300, 1080);
        GraphicsContext gc1 = canvas1.getGraphicsContext2D();
        gc1.setFill(javafx.scene.paint.Color.LIGHTGRAY);
        gc1.fillRect(0, 0, 1300, 1080);
        // Create the second canvas with another image
        Canvas canvas2 = new Canvas(1300, 1080);
        GraphicsContext gc2 = canvas2.getGraphicsContext2D();
        Image image2 = new Image("resources/img/henry.jpg");
        gc2.drawImage(image2, 0, 0, 977, 864);

        Canvas canvas3 = new Canvas(977, 864);
        GraphicsContext gc3 = canvas3.getGraphicsContext2D();
       
        Circle circle = new Circle(5);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.AQUA);
        circle.setStrokeWidth(2);

        // Enable mouse event handling for dragging
        double[] dragDelta = new double[]{0.0, 0.0};

        circle.setOnMousePressed((MouseEvent event) -> {
            dragDelta[0] = circle.getCenterX() - event.getSceneX();
            dragDelta[1] = circle.getCenterY() - event.getSceneY();
        });

        circle.setOnMouseDragged((MouseEvent event) -> {
            double x = event.getSceneX() + dragDelta[0];
            double y = event.getSceneY() + dragDelta[1];

            // Update the circle's position
            circle.setTranslateX(x);
            circle.setTranslateY(y);


            // Print or use the updated position as needed
            System.out.println("Circle position: (" + x + ", " + y + ")");
        });
        
        StackPane root = new StackPane();
        root.getChildren().addAll(canvas1, canvas2,circle);
        

        // Create a scene and set it on the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        
        primaryStage.setMaximized(true);
        // Show the stage
        primaryStage.show();
    }
}
