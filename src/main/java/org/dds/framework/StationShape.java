package org.dds.framework;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StationShape extends StackPane {

    private StackPane stationShape;
    private final Circle outputCircle;
    private final Circle outputCircleBorder;

    public StationShape(String stationName, double X, double Y) {
        outputCircle = new Circle(0,0,20, Color.LIGHTGRAY);
        outputCircleBorder = new Circle(0,0,22, Color.BLACK);
        Text id = new Text(stationName);
        id.setUnderline(true);
        id.setOpacity(0.6);
        id.setFont(new Font("Consolas", 15));
        id.setTranslateY(32);
        id.setTranslateX(-38);

        stationShape = new StackPane();
        stationShape.setTranslateX(X);
        stationShape.setTranslateY(Y);
        stationShape.getChildren().addAll(outputCircleBorder, outputCircle, id);
    }

    public StackPane createStation() {
        return stationShape;
    }
}
