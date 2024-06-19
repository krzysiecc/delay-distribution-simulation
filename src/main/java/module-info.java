module org.dds {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.dds.controller to javafx.fxml;
    opens org.dds.window to javafx.fxml;


    exports org.dds.controller;
    exports org.dds.window;
}