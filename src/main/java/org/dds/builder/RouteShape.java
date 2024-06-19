package org.dds.builder;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class RouteShape extends Pane {

    private final Pane outputLine;

    public RouteShape(boolean sec, double XA, double YA, double XB, double YB) {

//        Line line = new Line(XA+10, YA+10, XB+10, YB+10);
//        Line lineWhite = new Line(XA+10, YA+10, XB+10, YB+10);

        Line line = new Line(XA, YA, XB, YB);
        Line lineWhite = new Line(XA, YA, XB, YB);

        line.setStrokeWidth(5);
        lineWhite.setStroke(Color.WHITE);
        lineWhite.setStrokeWidth(2.5);

        outputLine = new Pane();

        if (sec) {
            outputLine.getChildren().addAll(line, lineWhite);
        } else {
            line.setStrokeWidth(1.5);
            outputLine.getChildren().add(line);
        }
    }

    public Pane createRoute() {
        return outputLine;
    }
}
