package org.dds.builder;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import org.dds.objects.Station;
import org.dds.objects.Train;

public class TrainShape extends Pane {
    private Pane trainShape;

    public TrainShape(Train train) {
        Circle outputCircle = new Circle(0, 0, 10, Color.RED);
        Label number = new Label(String.valueOf(train.getTrainID()));
        number.setFont(new Font("Consolas",15));
        number.setTranslateX(-20);
        number.setTranslateY(8);

        trainShape = new Pane();
        trainShape.getChildren().addAll(outputCircle, number);
        trainShape.setTranslateX(train.getX());
        trainShape.setTranslateY(train.getY());

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(240), trainShape);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);

        ScaleTransition reverseTransition = new ScaleTransition(Duration.millis(240), trainShape);
        reverseTransition.setFromX(1.5);
        reverseTransition.setFromY(1.5);
        reverseTransition.setToX(1);
        reverseTransition.setToY(1);

        trainShape.setOnMouseEntered(event -> {
            scaleTransition.play();
        });

        trainShape.setOnMouseExited(event -> {
            scaleTransition.stop();
            reverseTransition.play();
        });

    }

    public Pane createTrain() {
        return trainShape;
    }
}
