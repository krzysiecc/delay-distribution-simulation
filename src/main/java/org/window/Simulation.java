package org.window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Simulation extends Application {

    public static void main(String[] args) {
        launch(args);
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
     *  to oznacza, że każdy kolejny element jest zależny od poprzedniego, np. linie i kropki symbolizujące mapę są podporządkowane wielkości okna sceny
     *  które podczas rekalkulacji wymiarów, będzie wpływać także na wszystkie elementy podległe jemu, w tym wspomniane kształty.
     *  </p>
      */

    @Override
    public void start(Stage stage) {
        var scene = new Scene(new StackPane(), 1280, 720);
        stage.setScene(scene);
        stage.show();


    }
}
