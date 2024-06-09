package org.dds.window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class ApplicationWindow extends Application {


    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     *   <p>
     *       Main-class aplikacji JavaFX rozszerza klasę {@link javafx.application.Application}, gdzie
     *       metoda start() jest głównym punktem wejścia dla wszystkich instancji aplikacji JavaFX w projekcie.
     *   </p>
     *
     *   <p>
     *       {@link javafx.stage.Stage} jest klasą najwyższą w hierarchii, hierarchicznie jemu podległe są kolejne {@link javafx.scene.Scene}.
     *   </p>
     *
     * <p>
     *  Z uwagi na system działania i kreowania scen w bibliotece JavaFX, wszystkie elementy sceny są spięte drzewem zależności
     * </p> <p>to oznacza, że każdy kolejny element jest zależny od poprzedniego, np. linie i kropki symbolizujące mapę są podporządkowane wielkości okna sceny
     *  które podczas rekalkulacji wymiarów, będzie wpływać także na wszystkie elementy podległe jemu, w tym wspomniane kształty.
     *  </p>
     */

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("DDS");

        primaryStage.initStyle(StageStyle.DECORATED);

        primaryStage.setHeight(960);
        primaryStage.setWidth(1280);
        primaryStage.setResizable(false);

        Image appIcon = new Image("/clock_icon.jpg");
        primaryStage.getIcons().add(appIcon);

        Parent mainScene = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("EntryScene.fxml")));
        primaryStage.setScene(new Scene(mainScene));
        primaryStage.show();
    }

    @Override
    public void stop() {

    }
}

