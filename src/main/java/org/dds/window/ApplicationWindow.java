package org.dds.window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.dds.framework.TextOutputStream;

import java.io.PrintStream;
import java.util.Objects;

public class ApplicationWindow extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     *   <p>
     *       Main class of teh JavaFX application extends class {@link javafx.application.Application}, where
     *       start() method is the main entry point for every application instance of the project.
     *   </p>
     *
     *   <p>
     *       {@link javafx.stage.Stage} is situatued one top of the hierarchy, the children are {@link javafx.scene.Scene}.
     *   </p>
     *
     * <p>
     *     Due to the system of operation and scene creation in the JavaFX library, all scene elements are connected by a dependency tree.
     * </p> <p> This means that each subsequent element depends on the previous one, e.g. lines and dots symbolizing the map are subordinated to the size of the scene window
     * which, when recalculating dimensions, will also affect all elements subject to it, including the mentioned shapes.</p>
     *
     * <p>The icon connected to the application (@ is an {@link Image} added to the icon-children stack of the main {@link Stage}. </p>
     */

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("DDS");

        primaryStage.initStyle(StageStyle.DECORATED);

        primaryStage.setHeight(768); // 768 / 960
        primaryStage.setWidth(1024); // 1024 / 1280
        primaryStage.setResizable(true);

        // Setting the minimum and maximum width and height of the window base.
        // If the setResizable value is set to false, consecutive values are not in use.

        primaryStage.setMinHeight(768);
        primaryStage.setMinWidth(1024);

        primaryStage.setMaxHeight(960);
        primaryStage.setMaxWidth(1280);

        // The icon is created within the application via an {@link Image} object added to the icon-children stack of the main {@link Stage}

        Image appIcon = new Image("/clock_icon.jpg");
        primaryStage.getIcons().add(appIcon);

        // Loading only first scene (welcoming the user)
        Parent mainScene = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("EntryScene.fxml")));
        primaryStage.setScene(new Scene(mainScene));
        primaryStage.show();
    }

    @Override
    public void stop() {

    }
}

