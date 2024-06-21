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
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.dds.framework.FrameAdvance;
import org.dds.framework.Initialization;
import org.dds.builder.RouteShape;
import org.dds.builder.StationShape;
import org.dds.builder.TrainShape;
import org.dds.objects.Track;
import org.dds.objects.Station;
import org.dds.objects.Train;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.awt.Desktop;
import java.net.URI;

import static org.dds.framework.Clock.*;
import static org.dds.framework.FrameAdvance.adv;

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
    private Slider animationSpeed;

    @FXML
    private MenuItem docsButton;

    @FXML
    private MenuItem exitButton;

    private DoubleProperty animationSpeedHandler;
    private Timeline simulation;

    private Group trainsOnMap;
    private ArrayList<Train> trains;

    /**
     *  <p>After initializing all the FXML objects (inherited from .fxml file through an override) function initialize() from controller initialization interface
     * {@link Initializable} is induced. The approach is mainly focused on a injection template, thus in consequence it helps with the background initialization of the main controller
     * controlling visible elements of the simulation. </p>
     *
     * <p> In the overridden initialize function there are 4 other co-related functions called:
     *     </p>
     * <p>initializeSimulation() - initializing simulation Timeline object (setting cycle count to infinite)</p>
     * <p>initializeMap() - initializing visible map objects ({@link Station}, {@link Track} and {@link Train})</p>
     * <p>initializeInterfaceObjects() - creating actions and responses for UI elements</p>
     * <p>initializeTickControl() - delegating tick control to other elements</p>
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
        Initialization.initializeObjects();

        //

        ArrayList<Station> stationCoordinates = Initialization.getStations();
        Group stationPoints = new Group();

        // Change coordinates into visible circles

        for (Station station : stationCoordinates) {
            stationPoints.getChildren().add(new StationShape(station.getStationName(), station.getX(), station.getY()).createStation());
        }

        ArrayList<Track> trackCoordinates = Initialization.getTracks();
        Group routeLines = new Group();

        // Change coordinates into visible lines

        for (Track track : trackCoordinates) {
            routeLines.getChildren().add(new RouteShape(
                    track.isSecondTrack(),
                    track.getPoint1().getX(),
                    track.getPoint1().getY(),
                    track.getPoint2().getX(),
                    track.getPoint2().getY()).createRoute());
        }

        trains = Initialization.getTrains();
        trainsOnMap = new Group();
        for (Train train : trains) {
            trainsOnMap.getChildren().add(new TrainShape(train).createTrain());
        }

        for (Node trainshape : trainsOnMap.getChildren()) {
            trainshape.setVisible(false);
        }

        simulationMap.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
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

        docsButton.setOnAction(event -> {
            openDocURL();
        });

        exitButton.setOnAction(event -> {
            Platform.exit();
        });
    }

    // moving objects
    private void initializeTickControl() {
        simulation.getKeyFrames().add(
                new KeyFrame(Duration.seconds(0.1), event -> {

                    simulate();

                    if (disposeGraphic()) {
                        clock.setText(String.format("%05d", ANIMATION_FRAME));

                        for (int i = 0; i < trains.size(); i++) {

                            if (ANIMATION_FRAME == trains.get(i).getStartFrame()) {
                                trainsOnMap.getChildren().get(i).setVisible(true);
                                FrameAdvance.addPassenger(trains.get(i));

                            }

                            if (trains.get(i).isEndOfRoute()) {
                                trainsOnMap.getChildren().get(i).setVisible(false);
                            }

                            trainsOnMap.getChildren().get(i).setTranslateX(trains.get(i).getX());
                            trainsOnMap.getChildren().get(i).setTranslateY(trains.get(i).getY());
                        }
                    }
                })
        );
    }

    private void openDocURL() {
        try {
            // Ensure that the Desktop API is supported on the current platform
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://github.com/krzysiecc/delay-distribution-simulation/tree/master"));
            } else {
                System.out.println("Desktop or browse action not supported");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public double getAnimationSpeed() {
        return animationSpeedHandler.get();
    }

    public int getFrameNumber() {
        return ANIMATION_FRAME;
    }
}