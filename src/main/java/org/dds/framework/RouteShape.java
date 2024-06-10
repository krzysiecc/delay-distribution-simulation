package org.dds.framework;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RouteShape extends Pane {

    private final Pane outputLine;
    private final Line line;
    private final Line lineWhite;

    public RouteShape(boolean sec, double XA, double YA, double XB, double YB) {

        // vertical - horizontal - skos
        if (XA == XB) {
            line = new Line(XA + 24, YA + 20, XB + 24, YB + 20);
            lineWhite = new Line(XA + 24, YA + 20, XB + 24, YB + 20);
        } else if (YA == YB) {
            line = new Line(XA + 20, YA + 24, XB + 20, YB + 24);
            lineWhite = new Line(XA + 20, YA + 24, XB + 20, YB + 24);
        } else {
            line = new Line(XA + 20, YA + 20, XB + 20, YB + 20);
            lineWhite = new Line(XA + 20, YA + 20, XB + 20, YB + 20);
        }

        line.setStrokeWidth(8.0);
        lineWhite.setStroke(Color.WHITE);
        lineWhite.setStrokeWidth(3.0);

        outputLine = new Pane();

        if (sec) {
            outputLine.getChildren().addAll(line, lineWhite);
        } else {
            line.setStrokeWidth(2.5);
            outputLine.getChildren().add(line);
        }
    }

    public Pane createRoute() {
        return outputLine;
    }
}
