package org.dds.builder;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class StationShape extends StackPane {

    private final Pane stationShape;

    public StationShape(String stationName, double X, double Y) {

        Circle outputCircle = new Circle(0, 0, 9, Color.LIGHTGRAY);
        Circle outputCircleBorder = new Circle(0, 0, 10, Color.BLACK);

        Label id = new Label(stationName);
        id.setTranslateX(10);
        id.setTranslateY(4);

        stationShape = new Pane();
        stationShape.setTranslateX(X);
        stationShape.setTranslateY(Y);
        stationShape.getChildren().addAll(outputCircleBorder, outputCircle, id);
    }

    public Pane createStation() {
        return stationShape;
    }
}
