package org.dds.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.dds.framework.Initialization;
import org.dds.framework.RouteShape;
import org.dds.framework.StationShape;
import org.dds.framework.TrainShape;
import org.dds.objects.Route;
import org.dds.objects.Station;
import org.dds.objects.Train.Train;

public class MainSceneController implements Initializable {

    @FXML
    private Pane simulationMap;

    @FXML
    private Text clock;

    @FXML
    public TextArea consoleInfo;

    @FXML
    private Text date;

    @FXML
    private Text dayOfTheWeek;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private Button exitButton;

    @FXML
    private Slider animationSpeed;

    private DoubleProperty animationSpeedHandler;
    private Timeline simulation;
    private static int ANIMATION_FRAME = 0;

    private Group trainsOnMap;

    /**
     * Wykonywane dopiero po załadowaniu roota (okna MainScene dla którego wywołujemy funkcję initialize)
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeSimulation();

        initializeMap();

        initializeInterfaceObjects();

        initializeTickControl();
    }

    public void initializeSimulation() {
        simulation = new Timeline();
        simulation.setCycleCount(Animation.INDEFINITE);

        animationSpeedHandler = new SimpleDoubleProperty(1.0);
        animationSpeedHandler.bind(animationSpeed.valueProperty());
        simulation.rateProperty().bind(animationSpeedHandler);
    }

    private void initializeMap() {

        // Initialization class methods
        new Initialization();
        //

        ArrayList<Station> stationCoordinates = Initialization.getStations();
        Group stationPoints = new Group();

        // change coordinates into visible circles
        for (Station station : stationCoordinates) {
            stationPoints.getChildren().add(new StationShape(station.getStationName(), station.getX(), station.getY()).createStation());
        }

        ArrayList<Route> routeCoordinates = Initialization.getRoutes();
        Group routeLines = new Group();

        // change coordinates into visible lines
        for (Route route : routeCoordinates) {
            routeLines.getChildren().add(new RouteShape(
                    route.isSecondTrack(),
                    route.getStart().getX(),
                    route.getStart().getY(),
                    route.getEnd().getX(),
                    route.getEnd().getY()).createRoute());
        }

        ArrayList<Train> trainList = Initialization.getTrainsOnMap();
        trainsOnMap = new Group();

        // create trains
        for (Train train : trainList) {
            trainsOnMap.getChildren().add(new TrainShape(train.get_NID(), train.getStartStation()).createTrain());
        }

        simulationMap.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        simulationMap.getChildren().add(routeLines);
        simulationMap.getChildren().add(stationPoints);
        simulationMap.getChildren().add(trainsOnMap);
    }

    public void initializeInterfaceObjects() {
        stopButton.setDisable(true);

        LocalDate currentDate = LocalDate.now();
        date.setText(String.valueOf(currentDate));

        dayOfTheWeek.setText(String.valueOf(currentDate.getDayOfWeek())
                .replace("MONDAY", "PONIEDZIAŁEK")
                .replace("TUESDAY", "WTOREK")
                .replace("WEDNESDAY", "ŚRODA")
                .replace("THURSDAY", "CZWARTEK")
                .replace("FRIDAY", "PIĄTEK")
                .replace("SATURDAY", "SOBOTA")
                .replace("SUNDAY", "NIEDZIELA"));

        startButton.setOnAction(event -> {
            simulation.play();
            startButton.setDisable(true);
            stopButton.setDisable(false);
        });

        stopButton.setOnAction(event -> {
            simulation.stop();
            startButton.setDisable(false);
            stopButton.setDisable(true);
        });

        exitButton.setOnAction(event -> {
            Platform.exit();
        });
    }

    // moving objects
    private void initializeTickControl() {
        ANIMATION_FRAME = 0;
        simulation.getKeyFrames().add(
                new KeyFrame(Duration.seconds(0.2), event -> {
                    clock.setText(String.format("%05d", ++ANIMATION_FRAME));
                })
        );

        simulation.getKeyFrames().add(
                new KeyFrame(Duration.seconds(0.2), event -> {
                    trainsOnMap.getChildren().forEach(train -> {
                        train.setTranslateX(train.getTranslateX() + 1);
                    });
                })
        );
    }


    public double getAnimationSpeed() {
        return animationSpeedHandler.get();
    }

    public int getFrameNumber() {
        return ANIMATION_FRAME;
    }
}