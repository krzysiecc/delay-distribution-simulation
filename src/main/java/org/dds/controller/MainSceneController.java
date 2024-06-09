package org.dds.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    @FXML
    private Text clock;

    @FXML
    private TextField consoleOutput;

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

    /**
     * Wykonywane dopiero po załadowaniu roota (okna MainScene dla którego wywołujemy funkcję initialize)
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeSimulation();

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

    private void initializeTickControl() {
        ANIMATION_FRAME = 0;
        simulation.getKeyFrames().add(new KeyFrame(Duration.seconds(0.5), event -> {
            clock.setText(String.format("%05d", ++ANIMATION_FRAME));
        }));
    }

    public DoubleProperty getAnimationSpeed() {
        return animationSpeedHandler;
    }

    public int getFrameNumber() {
        return ANIMATION_FRAME;
    }
}